
package za.ac.cput.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.repository.UserAuthRepository;
import za.ac.cput.service.IService.IUserAuthService;

@Service
public class UserAuthService implements IUserAuthService {

    private final UserAuthRepository userAuthRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    @Autowired
    public UserAuthService(
            UserAuthRepository userAuthRepository,
            UserService userService,
            PasswordEncoder passwordEncoder) {

        this.userAuthRepository = userAuthRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAuth create(UserAuth userAuth) {
        return userAuthRepository.save(userAuth);
    }

    @Override
    public UserAuth read(Long id) {
        return userAuthRepository.findById(id).orElse(null);
    }

    @Override
    public UserAuth update(UserAuth userAuth) {
        return userAuthRepository.save(userAuth);
    }

    @Override
    public void delete(Long id) {
        userAuthRepository.deleteById(id);
    }

    @Override
    public List<UserAuth> getAll() {
        return userAuthRepository.findAll();
    }

    @Override
    public List<UserAuth> getByUser(User user) {
        return userAuthRepository.findByUser(user);
    }

    @Override
    public List<UserAuth> getByUserId(Long userId) {
        return userAuthRepository.findByUser_UserId(userId);
    }

    @Override
    public List<UserAuth> getByEmail(String email) {
        return userAuthRepository.findByUser_Email(email);
    }

    @Override
    public boolean existsByUser(User user) {
        return userAuthRepository.existsByUser(user);
    }

    private void validateRegistration(
            String name,
            String surname,
            String email,
            String password) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }

        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Surname is required.");
        }

        if (email == null ||
                !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new IllegalArgumentException(
                    "A valid email address is required.");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException(
                    "Password must contain at least 8 characters.");
        }
    }

    @Override
    @Transactional
    public User register(Map<String, Object> body) {
        if (body == null) {
            throw new IllegalArgumentException(
                    "Registration details are required.");
        }

        String name = body.get("name") instanceof String
                ? ((String) body.get("name")).trim()
                : null;

        String surname = body.get("surname") instanceof String
                ? ((String) body.get("surname")).trim()
                : null;

        String email = body.get("email") instanceof String
                ? ((String) body.get("email")).trim().toLowerCase()
                : null;

        String password = body.get("password") instanceof String
                ? (String) body.get("password")
                : null;

        validateRegistration(name, surname, email, password);

        if (userService.existsByEmail(email)) {
            throw new IllegalStateException(
                    "Email already registered.");
        }

        User user = User.builder()
                .name(name)
                .surname(surname)
                .studentNumber(
                        body.get("studentNumber") instanceof String
                                ? (String) body.get("studentNumber")
                                : null)
                .email(email)
                .contactNumber(
                        body.get("contactNumber") instanceof String
                                ? (String) body.get("contactNumber")
                                : null)
                .createdAt(LocalDateTime.now())
                .isTutor(Boolean.TRUE.equals(body.get("isTutor")))
                .isStudent(Boolean.TRUE.equals(body.get("isStudent")))
                .build();

        user = userService.create(user);

        UserAuth auth = UserAuth.builder()
                .user(user)
                .passwordHash(passwordEncoder.encode(password))
                .build();

        userAuthRepository.save(auth);

        return user;
    }

    @Override
    @Transactional
    public User verifyCredentials(String email, String password) {
        if (email == null || email.isBlank()
                || password == null || password.isBlank()) {
            throw new IllegalArgumentException(
                    "Email and password are required.");
        }

        User user = userService.getByEmail(
                email.trim().toLowerCase());

        if (user == null) {
            throw new BadCredentialsException(
                    "Invalid email or password.");
        }

        List<UserAuth> auths = getByUserId(user.getUserId());

        if (auths.isEmpty()) {
            throw new BadCredentialsException(
                    "Invalid email or password.");
        }

        UserAuth auth = auths.get(0);

        if (auth.getPasswordHash() == null
                || !passwordEncoder.matches(
                        password, auth.getPasswordHash())) {
            throw new BadCredentialsException(
                    "Invalid email or password.");
        }

        auth.setLastLogin(LocalDateTime.now());
        userAuthRepository.save(auth);

        return user;
    }
}

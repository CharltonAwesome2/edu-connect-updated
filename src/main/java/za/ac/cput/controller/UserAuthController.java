package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.service.UserAuthService;
import za.ac.cput.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user-auth")
public class UserAuthController {

    private final UserAuthService userAuthService;

    private final UserService userService;

    public UserAuthController(UserAuthService userAuthService, UserService userService) {
        this.userAuthService = userAuthService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserAuth> createUserAuth(@RequestBody UserAuth userAuth) {
        UserAuth createUserAuth = userAuthService.create(userAuth);
        return new ResponseEntity<>(createUserAuth, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<UserAuth> readUserAuth(@PathVariable Long id) {
        UserAuth readUserAuth = userAuthService.read(id);
        if (readUserAuth == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(readUserAuth, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserAuth> updateUserAuth(@RequestBody UserAuth userAuth) {
        UserAuth updatedUserAuth = userAuthService.update(userAuth);
        if (updatedUserAuth == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedUserAuth, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserAuth(@PathVariable Long id) {
        userAuthService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<UserAuth> getAllUserAuth() {
        return userAuthService.getAll();
    }

    @PostMapping("/by-user")
    public List<UserAuth> getByUser(@RequestBody User user) {
        return userAuthService.getByUser(user);
    }

    @GetMapping("/by-user-id/{userId}")
    public List<UserAuth> getByUserId(@PathVariable Long userId) {
        return userAuthService.getByUserId(userId);
    }

    @GetMapping("/by-email")
    public List<UserAuth> getByEmail(@RequestParam String email) {
        return userAuthService.getByEmail(email);
    }

    @PostMapping("/exists-by-user")
    public boolean existsByUser(@RequestBody User user) {
        return userAuthService.existsByUser(user);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        User user = userService.getByEmail(email); // inject IUserService
        if (user == null)
            return ResponseEntity.status(404).body(Map.of("message", "No account with that email."));

        List<UserAuth> auths = userAuthService.getByUserId(user.getUserId());
        if (auths.isEmpty())
            return ResponseEntity.status(404).body(Map.of("message", "No credentials for this user."));

        UserAuth auth = auths.get(0);
        // If using BCrypt: if (!passwordEncoder.matches(password, auth.getPasswordHash()))
        if (!password.equals(auth.getPasswordHash())) {
            return ResponseEntity.status(401).body(Map.of("message", "Incorrect password."));
        }

        auth.setLastLogin(LocalDateTime.now());
        userAuthService.update(auth);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> body) {
        String email = (String) body.get("email");
        String password = (String) body.get("password");

        if (userService.existsByEmail(email)) {
            return ResponseEntity.status(409).body(Map.of("message", "Email already registered."));
        }

        User user = User.builder()
                .name((String) body.get("name"))
                .surname((String) body.get("surname"))
                .studentNumber((String) body.get("studentNumber"))
                .email(email)
                .contactNumber((String) body.get("contactNumber"))
                .createdAt(LocalDateTime.now())
                .isTutor(Boolean.TRUE.equals(body.get("isTutor")))
                .isStudent(Boolean.TRUE.equals(body.get("isStudent")))
                .build();
        user = userService.create(user);

        UserAuth auth = UserAuth.builder()
                .user(user)
                .passwordHash(password) 
                .build();
        userAuthService.create(auth);

        return ResponseEntity.status(201).body(user);
    }

}

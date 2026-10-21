package za.ac.cput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.repository.UserAuthRepository;

@Service
public class UserAuthService implements IUserAuthService {

    private final UserAuthRepository userAuthRepository;

    @Autowired
    UserAuthService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
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
    public UserAuth getByUser(User user) {
        return userAuthRepository.findByUser(user).orElse(null);
    }

    @Override
    public UserAuth getByUserId(Long userId) {
        return userAuthRepository.findByUser_UserId(userId).orElse(null);
    }

    @Override
    public UserAuth getByEmail(String email) {
        return userAuthRepository.findByUser_Email(email).orElse(null);
    }

    @Override
    public boolean existsByUser(User user) {
        return userAuthRepository.existsByUser(user);
    }
}

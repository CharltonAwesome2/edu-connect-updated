package za.ac.cput.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.service.UserAuthService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-auth")
public class UserAuthController {

    private final UserAuthService userAuthService;

    public UserAuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
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

}


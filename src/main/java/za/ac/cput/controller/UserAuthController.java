package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.service.UserAuthService;

import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.BadCredentialsException;

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

    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody Map<String, String> body) {
        try {
            User user = userAuthService.verifyCredentials(
                    body.get("email"),
                    body.get("password"));

            return ResponseEntity.ok(user);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", e.getMessage()));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid email or password."));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> body) {
        try {
            User user = userAuthService.register(body);

            return ResponseEntity.status(HttpStatus.CREATED).body(user);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", e.getMessage()));

        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", e.getMessage()));
        }
    }

}

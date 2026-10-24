package za.ac.cput.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.IService.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createUser = userService.create(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<User> read(@PathVariable Long id) {
        User readUser = userService.read(id);
        if (readUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(readUser, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        User updateUser = userService.update(user);
        if (updateUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/by-email")
    public ResponseEntity<User> getByEmail(@RequestParam String email) {
        User user = userService.getByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/by-student-number")
    public ResponseEntity<User> getByStudentNumber(@RequestParam String studentNumber) {
        User user = userService.getByStudentNumber(studentNumber);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/exists-by-email")
    public ResponseEntity<Boolean> existsByEmail(@RequestParam String email) {
        return new ResponseEntity<>(userService.existsByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/exists-by-student-number")
    public ResponseEntity<Boolean> existsByStudentNumber(@RequestParam String studentNumber) {
        return new ResponseEntity<>(userService.existsByStudentNumber(studentNumber), HttpStatus.OK);
    }

    @GetMapping("/allTutors")
    public List<User> getAllTutors() {
        return userService.getAllTutors();
    }

    @GetMapping("/allStudent")
    public List<User> getAllStudents() {
        return userService.getAllStudents();
    }
}


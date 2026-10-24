package za.ac.cput.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.service.IService.ITutorProfileService;

import java.util.List;

        /**
         * TutorProfileController.java
         * TutorSubject REST controller
         * Author: Esaile Franck Siani Djiakeng
         * Date: 21 October 2026
         */

@RestController
@RequestMapping("/api/tutor-profile")
public class TutorProfileController {

    private final ITutorProfileService tutorProfileService;

    public TutorProfileController(ITutorProfileService tutorProfileService) {
        this.tutorProfileService = tutorProfileService;
    }

    @PostMapping("/create")
    public ResponseEntity<TutorProfile> create(@RequestBody TutorProfile tutorProfile) {
        TutorProfile createdTutorProfile = tutorProfileService.create(tutorProfile);
        return new ResponseEntity<>(createdTutorProfile, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<TutorProfile> read(@PathVariable Long id) {
        TutorProfile tutorProfile = tutorProfileService.read(id);
        if(tutorProfile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(tutorProfile, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TutorProfile> update(@RequestBody TutorProfile tutorProfile) {
        TutorProfile updatedTutorProfile = tutorProfileService.update(tutorProfile);
        if (updatedTutorProfile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTutorProfile, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tutorProfileService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<TutorProfile> getAll() {
        return tutorProfileService.getAll();
    }

    @GetMapping("/by-tutor-profile-id/{tutorProfileId}")
    public List<TutorProfile> getByTutorProfile(@PathVariable Long tutorProfileId) {
        return tutorProfileService.findByTutorProfileId(tutorProfileId);
    }

    @PostMapping("/by-user")
    public List<TutorProfile> getByUser(@RequestBody User user) {
        return tutorProfileService.findByUser(user);
    }

    @GetMapping("/by-user-id/{userId}")
    public List<TutorProfile> getByUserId(@PathVariable Long userId) {
        return tutorProfileService.findByUserId(userId);
    }

}

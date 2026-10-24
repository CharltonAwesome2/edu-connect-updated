package za.ac.cput.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.service.IService.ITutoringSessionService;

import java.util.List;

/**
         * TutorSessionController.java
         * TutorSubject REST controller
         * Author: Esaile Franck Siani Djiakeng
         * Date: 21 October 2026
         */

@RestController
@RequestMapping("/api/tutoring-session")
public class TutoringSessionController {

    private final ITutoringSessionService tutoringSessionService;

    public TutoringSessionController(ITutoringSessionService tutoringSessionService) {
        this.tutoringSessionService = tutoringSessionService;
    }

    @PostMapping("/create")
    public ResponseEntity<TutoringSession> create(@RequestBody TutoringSession tutoringSession) {
        TutoringSession createdTutoringSession = tutoringSessionService.create(tutoringSession);
        return new ResponseEntity<>(createdTutoringSession, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<TutoringSession> read(@PathVariable Long id) {
        TutoringSession tutoringSession = tutoringSessionService.read(id);
        if (tutoringSession == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tutoringSession, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TutoringSession> update(@RequestBody TutoringSession tutoringSession) {
        TutoringSession  updatedTutoringSession = tutoringSessionService.update(tutoringSession);
        if (updatedTutoringSession == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTutoringSession, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tutoringSessionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<TutoringSession> getAll() {
        return tutoringSessionService.getAll();
    }

    @GetMapping("/by-tutoring-session-id/{tutoringSessionId}")
    public List<TutoringSession> findByTutoringSessionId(@PathVariable Long tutoringSessionId) {
        return tutoringSessionService.findByTutoringSessionId(tutoringSessionId);
    }

    @PostMapping("/by-tutor-profile")
    public List<TutoringSession> findByTutorProfile(@RequestBody TutorProfile tutorProfile) {
        return tutoringSessionService.findByTutorProfile(tutorProfile);
    }

    @GetMapping("/by-tutor-profile-id/{tutorProfileId}")
    public List<TutoringSession> findByTutorProfileId(@PathVariable Long tutorProfileId) {
        return tutoringSessionService.findByTutorProfileId(tutorProfileId);
    }

    @PostMapping("/by-student")
    public List<TutoringSession> findByStudent(@RequestBody User student) {
        return tutoringSessionService.findByStudent(student);
    }

    @GetMapping("/by-student-id/{studentId}")
    public List<TutoringSession> findByStudentId(@PathVariable Long studentId) {
        return tutoringSessionService.findByStudentId(studentId);
    }

}


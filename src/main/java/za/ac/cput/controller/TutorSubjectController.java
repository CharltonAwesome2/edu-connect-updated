package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.service.ITutorSubjectService;

import java.util.List;

        /**
         * TutorSubjectController.java
         * TutorSubject REST controller
         * Author: Esaile Franck Siani Djiakeng
         * Date: 21 October 2026
         */

@RestController
@RequestMapping("/api/tutor-subject")
public class TutorSubjectController {

    private final ITutorSubjectService tutorSubjectService;

    public TutorSubjectController(ITutorSubjectService tutorSubjectService) {
        this.tutorSubjectService = tutorSubjectService;
    }

    @PostMapping("/create")
    public ResponseEntity<TutorSubject> create(@RequestBody TutorSubject tutorSubject) {
        TutorSubject createdTutorSubject = tutorSubjectService.create(tutorSubject);
        return new ResponseEntity<>(createdTutorSubject, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<TutorSubject> read(@PathVariable Long id) {
        TutorSubject tutorSubject = tutorSubjectService.read(id);
        if (tutorSubject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tutorSubject, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TutorSubject> update(@RequestBody TutorSubject tutorSubject) {
        TutorSubject updatedTutorSubject = tutorSubjectService.update(tutorSubject);
        if (updatedTutorSubject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTutorSubject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tutorSubjectService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TutorSubject>> getAll() {
        return new ResponseEntity<>(tutorSubjectService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/by-tutor-subject-id/{tutorSubjectId}")
    public ResponseEntity<List<TutorSubject>> findByTutorSubjectId(@PathVariable Long tutorSubjectId) {
        return new ResponseEntity<>(tutorSubjectService.findByTutorSubjectId(tutorSubjectId), HttpStatus.OK);
    }

    @PostMapping("/by-tutor-profile")
    public ResponseEntity<List<TutorSubject>> findByTutorProfile(@RequestBody TutorProfile tutorProfile) {
        return new ResponseEntity<>(tutorSubjectService.findByTutorProfile(tutorProfile), HttpStatus.OK);
    }

    @PostMapping("/by-subject")
    public ResponseEntity<List<TutorSubject>> findBySubject(@RequestBody Subject subject) {
        return new ResponseEntity<>(tutorSubjectService.findBySubject(subject), HttpStatus.OK);
    }
}

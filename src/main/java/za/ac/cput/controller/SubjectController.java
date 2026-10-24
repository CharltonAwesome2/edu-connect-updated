package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Subject;
import za.ac.cput.service.IService.ISubjectService;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private final ISubjectService subjectService;

    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/create")
    public ResponseEntity<Subject> create(@RequestBody Subject subject) {
        Subject createdSubject = subjectService.create(subject);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Subject> read(@PathVariable Long id) {
        Subject subject = subjectService.read(id);
        if (subject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Subject> update(@RequestBody Subject subject) {
        Subject updatedSubject = subjectService.update(subject);
        if (updatedSubject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subjectService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<Subject> getAll() {
        return subjectService.getAll();
    }
}

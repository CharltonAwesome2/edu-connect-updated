package za.ac.cput.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.service.IService.ITutorReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/tutor-review")
public class TutorReviewController {

    private final ITutorReviewService tutorReviewService;

    public TutorReviewController(ITutorReviewService tutorReviewService) {
        this.tutorReviewService = tutorReviewService;
    }

    @PostMapping("/create")
    public ResponseEntity<TutorReview> create(@RequestBody TutorReview tutorReview){
        TutorReview tutorReviewCreated = tutorReviewService.create(tutorReview);
        return new ResponseEntity<>(tutorReviewCreated, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<TutorReview> read(@PathVariable Long id){
        TutorReview tutorReview = tutorReviewService.read(id);
        if(tutorReview == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tutorReview, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TutorReview> update(@RequestBody TutorReview tutorReview){
        TutorReview tutorReviewUpdated = tutorReviewService.update(tutorReview);
        if(tutorReviewUpdated == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tutorReviewUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        tutorReviewService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<TutorReview> getAll(){
        return tutorReviewService.getAll();
    }

    @GetMapping("/by-tutor-id/{id}")
    public List<TutorReview> findByTutorId(@PathVariable Long id) {
        return tutorReviewService.findByTutorId(id);
    }

    @GetMapping("/by-student-id/{id}")
    public List<TutorReview> findByStudentId(@PathVariable Long id) {
        return tutorReviewService.findByStudentId(id);
    }

}

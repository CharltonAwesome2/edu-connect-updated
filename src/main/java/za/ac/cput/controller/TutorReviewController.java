package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorReview;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
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
    public ResponseEntity<TutorReview> create(@RequestBody TutorReview tutorReview) {
        TutorReview tutorReviewCreated = tutorReviewService.create(tutorReview);
        return new ResponseEntity<>(tutorReviewCreated, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<TutorReview> read(@PathVariable Long id) {
        TutorReview tutorReview = tutorReviewService.read(id);
        if (tutorReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tutorReview, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TutorReview> update(@RequestBody TutorReview tutorReview) {
        TutorReview tutorReviewUpdated = tutorReviewService.update(tutorReview);
        if (tutorReviewUpdated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tutorReviewUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tutorReviewService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<TutorReview> getAll() {
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

    @PostMapping("/by-session")
    public ResponseEntity<TutorReview> getBySession(@RequestBody TutoringSession session) {
        TutorReview review = tutorReviewService.getBySession(session);
        if (review == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping("/exists-by-session")
    public ResponseEntity<Boolean> existsBySession(@RequestBody TutoringSession session) {
        return new ResponseEntity<>(tutorReviewService.existsBySession(session), HttpStatus.OK);
    }

    @PostMapping("/by-student")
    public List<TutorReview> getAllByStudent(@RequestBody User student) {
        return tutorReviewService.getAllByStudent(student);
    }

    @GetMapping("/by-student-id/{userId}")
    public List<TutorReview> getAllByStudentId(@PathVariable Long userId) {
        return tutorReviewService.getAllByStudentId(userId);
    }

    @PostMapping("/by-tutor-profile")
    public List<TutorReview> getAllByTutorProfile(@RequestBody TutorProfile tutorProfile) {
        return tutorReviewService.getAllByTutorProfile(tutorProfile);
    }

    @PostMapping("/public-by-tutor-profile")
    public List<TutorReview> getAllPublicByTutorProfile(@RequestBody TutorProfile tutorProfile) {
        return tutorReviewService.getAllPublicByTutorProfile(tutorProfile);
    }

    @PostMapping("/by-tutor-profile-min-rating")
    public List<TutorReview> getAllByTutorProfileWithMinRating(
            @RequestBody TutorProfile tutorProfile,
            @RequestParam int minRating) {
        return tutorReviewService.getAllByTutorProfileWithMinRating(tutorProfile, minRating);
    }

    @PostMapping("/average-rating")
    public ResponseEntity<Double> getAverageRating(@RequestBody TutorProfile tutorProfile) {
        return new ResponseEntity<>(tutorReviewService.getAverageRating(tutorProfile), HttpStatus.OK);
    }

    @PostMapping("/count-by-tutor-profile")
    public ResponseEntity<Long> countByTutorProfile(@RequestBody TutorProfile tutorProfile) {
        return new ResponseEntity<>(tutorReviewService.countByTutorProfile(tutorProfile), HttpStatus.OK);
    }

}

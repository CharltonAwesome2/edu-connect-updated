package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.BookingRequest;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.enums.BookingStatus;
import za.ac.cput.service.IService.IBookingRequestService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/booking-request")
public class BookingRequestController {

    private final IBookingRequestService bookingRequestService;

    public BookingRequestController(IBookingRequestService bookingRequestService) {
        this.bookingRequestService = bookingRequestService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookingRequest> create(@RequestBody BookingRequest bookingRequest) {
        BookingRequest createdBookingRequest = bookingRequestService.create(bookingRequest);
        return new ResponseEntity<>(createdBookingRequest, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<BookingRequest> read(@PathVariable Long id) {
        BookingRequest bookingRequest = bookingRequestService.read(id);
        if (bookingRequest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookingRequest, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<BookingRequest> update(@RequestBody BookingRequest bookingRequest) {
        BookingRequest updatedBookingRequest = bookingRequestService.update(bookingRequest);
        if (updatedBookingRequest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedBookingRequest, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookingRequestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<BookingRequest> getAll() {
        return bookingRequestService.getAll();
    }

    // ---- MISSING ENDPOINTS ----

    @PostMapping("/by-student")
    public List<BookingRequest> getAllByStudent(@RequestBody User student) {
        return bookingRequestService.getAllByStudent(student);
    }

    @GetMapping("/by-student-id/{userId}")
    public List<BookingRequest> getAllByStudentId(@PathVariable Long userId) {
        return bookingRequestService.getAllByStudentId(userId);
    }

    @PostMapping("/by-tutor-profile")
    public List<BookingRequest> getAllByTutorProfile(@RequestBody TutorProfile tutorProfile) {
        return bookingRequestService.getAllByTutorProfile(tutorProfile);
    }

    @PostMapping("/by-subject")
    public List<BookingRequest> getAllBySubject(@RequestBody Subject subject) {
        return bookingRequestService.getAllBySubject(subject);
    }

    @GetMapping("/by-status/{status}")
    public List<BookingRequest> getAllByStatus(@PathVariable BookingStatus status) {
        return bookingRequestService.getAllByStatus(status);
    }

    // @PostMapping("/by-student-and-status")
    // public List<BookingRequest> getAllByStudentAndStatus(
    //         @RequestParam Long userId,
    //         @RequestParam BookingStatus status) {
    // }

    @PostMapping("/by-tutor-profile-and-status")
    public List<BookingRequest> getAllByTutorProfileAndStatus(
            @RequestBody TutorProfile tutorProfile,
            @RequestParam BookingStatus status) {
        return bookingRequestService.getAllByTutorProfileAndStatus(tutorProfile, status);
    }

    @GetMapping("/by-start-time-between")
    public List<BookingRequest> getAllByStartTimeBetween(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return bookingRequestService.getAllByStartTimeBetween(start, end);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<BookingRequest> updateStatus(
            @PathVariable Long id,
            @RequestParam BookingStatus status) {
        BookingRequest updated = bookingRequestService.updateStatus(id, status);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
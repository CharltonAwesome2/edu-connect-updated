package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.BookingRequest;
import za.ac.cput.service.IService.IBookingRequestService;

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
}

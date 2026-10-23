// BookingRequestService.java
// BookingRequest service class
// Author: Reotshepile Stock (230875807)
// Date: 21 October 2026


package za.ac.cput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import za.ac.cput.domain.BookingRequest;
import za.ac.cput.repository.BookingRequestRepository;

public class BookingRequestService implements IBookingRequestService {

    private final BookingRequestRepository bookingRequestRepository;

    @Autowired
    public BookingRequestService(
            BookingRequestRepository bookingRequestRepository) {
        this.bookingRequestRepository = bookingRequestRepository;
    }

    @Override
    public BookingRequest create(BookingRequest bookingRequest) {
        return bookingRequestRepository.save(bookingRequest);
    }

    @Override
    public BookingRequest read(Long id) {
        return bookingRequestRepository.findById(id).orElse(null);
    }

    @Override
    public BookingRequest update(BookingRequest bookingRequest) {
        return bookingRequestRepository.save(bookingRequest);
    }

    @Override
    public void delete(Long id) {
        bookingRequestRepository.deleteById(id);
    }

    @Override
    public List<BookingRequest> getAll() {
        return bookingRequestRepository.findAll();
    }
}

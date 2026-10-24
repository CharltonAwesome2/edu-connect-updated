package za.ac.cput.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Availability;
import za.ac.cput.service.IService.IAvailabilityService;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    private final IAvailabilityService availabilityService;

    public AvailabilityController(IAvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @PostMapping("/create")
    public ResponseEntity<Availability> create(@RequestBody Availability availability) {
        Availability createdAvailability = availabilityService.create(availability);
        return new ResponseEntity<>(createdAvailability, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Availability> read(@PathVariable Long id) {
        Availability availability = availabilityService.read(id);
        if (availability == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(availability, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Availability> update(@RequestBody Availability availability) {
        Availability updatedAvailability = availabilityService.update(availability);
        if (updatedAvailability == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAvailability, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        availabilityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public List<Availability> getAll() {
        return availabilityService.getAll();
    }

    @GetMapping("/by-availability-id/{availabilityId}")
    public List<Availability> findByAvailabilityId(@PathVariable Long availabilityId) {
        return availabilityService.findByAvailabilityId(availabilityId);
    }

    @GetMapping("/by-tutor-profile-id/{tutorProfileId}")
    public List<Availability> findByTutorProfileId(@PathVariable Long tutorProfileId) {
        return availabilityService.findByTutorProfileId(tutorProfileId);
    }

    @GetMapping("/by-day/{dayOfWeek}")
    public List<Availability> findByDayOfWeek(@PathVariable DayOfWeek dayOfWeek) {
        return availabilityService.getAllAvailabilityByDayOfWeek(dayOfWeek);
    }

}

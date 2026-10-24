package za.ac.cput.service;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.Availability;
import za.ac.cput.repository.AvailabilityRepository;
import za.ac.cput.service.IService.IAvailabilityService;

@Service
public class AvailabilityService implements IAvailabilityService {

    private final AvailabilityRepository availabilityRepository;

    @Autowired
    AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public Availability create(Availability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public Availability read(Long id) {
        return availabilityRepository.findById(id).orElse(null);
    }

    @Override
    public Availability update(Availability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public void delete(Long id) {
        availabilityRepository.deleteById(id);
    }

    @Override
    public List<Availability> getAll() {
        return availabilityRepository.findAll();
    }

    @Override
    public List<Availability> findByAvailabilityId(Long availabilityId) {
        return availabilityRepository.findByAvailabilityId(availabilityId);
    }

    @Override
    public List<Availability> findByTutorProfileId(Long tutorProfileId) {
        return availabilityRepository.findByTutorProfile_TutorProfileId(tutorProfileId);
    }

    @Override
    public List<Availability> getAllAvailabilityByDayOfWeek(DayOfWeek dayOfWeek) {
        return availabilityRepository.findAllByDayOfWeek(dayOfWeek);
    }

}

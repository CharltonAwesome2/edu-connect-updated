package za.ac.cput.service.IService;

import java.time.DayOfWeek;
import java.util.List;

import za.ac.cput.domain.Availability;

public interface IAvailabilityService extends service<Availability, Long> {
    List<Availability> findByAvailabilityId(Long availabilityId);
    List<Availability> findByTutorProfileId(Long tutorProfileId);
    List<Availability> getAllAvailabilityByDayOfWeek(DayOfWeek dayOfWeek);
}

package za.ac.cput.repository;
import java.time.DayOfWeek;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.domain.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Long>{

    List<Availability> findByAvailabilityId(Long availabilityId);
    List<Availability> findByTutorProfile_TutorProfileId(Long tutorProfileId);
    List<Availability> findAllByDayOfWeek(DayOfWeek dayOfWeek);
    
}

package za.ac.cput.repository;
import java.time.DayOfWeek;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.domain.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Long>{

    List<Availability> findAllByDayOfWeek(DayOfWeek dayOfWeek);
    
}

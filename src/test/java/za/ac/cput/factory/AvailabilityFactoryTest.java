package za.ac.cput.factory;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Availability;
import za.ac.cput.domain.TutorProfile;

public class AvailabilityFactoryTest {

    TutorProfile profile = new TutorProfile();
    DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
    LocalDateTime starTime = LocalDateTime.now();
    LocalDateTime endTime = starTime.plusHours(1);

    private Availability availability = AvailabilityFactory.createAvailability(profile,
            dayOfWeek,
            starTime,
            endTime,
            false);

    @Test
    void createAvailability() {
        System.out.println(availability);
    }
}

package za.ac.cput.factory;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import za.ac.cput.domain.Availability;
import za.ac.cput.domain.TutorProfile;

public class AvailabilityFactoryTest {

    TutorProfile profile = TutorProfile.builder().build();
    DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
    LocalDateTime starTime = LocalDateTime.now();
    LocalDateTime endTime = starTime.plusHours(1);

    @Test
    void createAvailability() {

        Availability availability = AvailabilityFactory.createAvailability(profile,
                dayOfWeek,
                starTime,
                endTime,
                false);

        assertNotNull(availability);
        assertNotNull(availability.getAvailabilityId());

        assertEquals(profile, availability.getTutorProfile());
        assertEquals(dayOfWeek, availability.getDayOfWeek());
        assertEquals(starTime, availability.getStartTime());
        assertEquals(endTime, availability.getEndTime());

    }

    @Test
    void createAvailabilityWithNullProfile() {
        Availability availability = AvailabilityFactory.createAvailability(null,
                dayOfWeek,
                starTime,
                endTime,
                false);

        assertNull(availability);
    }

    @Test
    void createAvailabilityWithNullDayOfWeek() {
        Availability availability = AvailabilityFactory.createAvailability(profile,
                null,
                starTime,
                endTime,
                false);

        assertNull(availability);
    }

    @Test
    void createAvailabilityWithNullStartTime() {
        Availability availability = AvailabilityFactory.createAvailability(profile,
                dayOfWeek,
                null,
                endTime,
                false);

        assertNull(availability);
    }

    @Test
    void createAvailabilityWithNullEndTime() {
        Availability availability = AvailabilityFactory.createAvailability(profile,
                dayOfWeek,
                starTime,
                null,
                false);

        assertNull(availability);
    }
}

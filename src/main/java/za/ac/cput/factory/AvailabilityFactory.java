package za.ac.cput.factory;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import za.ac.cput.domain.Availability;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.util.HelperUtil;

public class AvailabilityFactory {

    public static Availability createAvailability(
            TutorProfile profile,
            DayOfWeek dayOfWeek,
            LocalDateTime startTime,
            LocalDateTime endTime,
            boolean isRecurring) {

        if (profile == null || dayOfWeek == null || startTime == null || endTime == null) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return Availability.builder()
                .availabilityId(id)
                .tutorProfile(profile)
                .dayOfWeek(dayOfWeek)
                .startTime(startTime)
                .endTime(endTime)
                .isRecurring(isRecurring)
                .build();

    }
}

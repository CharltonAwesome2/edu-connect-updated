package za.ac.cput.factory;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import za.ac.cput.domain.Availability;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.util.HelperUtil;

public class AvailabilityFactory {

    public static Availability createAvailability(
            TutorProfile profile, DayOfWeek dayOfWeek,
            LocalDateTime startTime, LocalDateTime endtimDate,
            boolean isRecurring) {

        if (profile == null || dayOfWeek == null || startTime == null || endtimDate == null) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return new Availability.Builder()
                .setId(id)
                .setTutorProfile(profile)
                .setDayOfWeek(dayOfWeek)
                .setStartTime(startTime)
                .setEndTime(endtimDate)
                .setRecurring(isRecurring)
                .build();

    }
}

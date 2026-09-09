package za.ac.cput.factory;

import java.time.LocalDateTime;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.util.HelperUtil;

public class TutorProfileFactory {

    public TutorProfile createTutorProfile(User user, String bio, int yearsExperience, double hourlyRate,
            double averageRating, LocalDateTime createdAt) {

        if (user == null || createdAt == null || HelperUtil.isNullOrEmpty(bio)) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return new TutorProfile.Builder()
                .setTutorProfileId(id)
                .setUser(user)
                .setBio(bio)
                .setYearsExperience(yearsExperience)
                .setHourlyRate(hourlyRate)
                .setAverageRating(averageRating)
                .setCreatedAt(createdAt)
                .build();
    }
}
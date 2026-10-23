package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;

public class TutorProfileFactoryTest {

    User user = User.builder().build();
    String bio = "Tutor profile biography";
    int yearsExperience = 2;
    BigDecimal hourlyRate = new BigDecimal(25.00);
    double averageRating = 4.3;
    LocalDateTime createdAt = LocalDateTime.now();
    boolean isVerified = true;

    @Test
    void createTutorProfile() {
        TutorProfile tutorProfile = TutorProfileFactory.createTutorProfile(user,
                bio,
                yearsExperience,
                hourlyRate,
                averageRating,
                createdAt,
                isVerified);

        assertNotNull(tutorProfile);
        assertNotNull(tutorProfile.getTutorProfileId());

        assertEquals(user, tutorProfile.getUser());
        assertEquals(bio, tutorProfile.getBio());
        assertEquals(yearsExperience, tutorProfile.getYearsExperience());
        assertEquals(hourlyRate, tutorProfile.getHourlyRate());
        assertEquals(averageRating, tutorProfile.getAverageRating());
        assertEquals(createdAt, tutorProfile.getCreatedAt());
        assertTrue(tutorProfile.isVerified());
    }

    @Test
    void createTutorProfileWithEmptyUser() {
        TutorProfile tutorProfile = TutorProfileFactory.createTutorProfile(null,
                bio,
                yearsExperience,
                hourlyRate,
                averageRating,
                createdAt,
                isVerified);

        assertNull(tutorProfile);
    }

    @Test
    void createTutorProfileWithNullBio() {
        TutorProfile tutorProfile = TutorProfileFactory.createTutorProfile(user,
                null,
                yearsExperience,
                hourlyRate,
                averageRating,
                createdAt,
                isVerified);

        assertNotNull(tutorProfile);
    }

    @Test
    void createTutorProfileWithEmptyBio() {
        TutorProfile tutorProfile = TutorProfileFactory.createTutorProfile(user,
                "",
                yearsExperience,
                hourlyRate,
                averageRating,
                createdAt,
                isVerified);

        assertNotNull(tutorProfile);
    }

    @Test
    void createTutorProfileWithNegativeYearsExperience() {
        TutorProfile tutorProfile = TutorProfileFactory.createTutorProfile(user,
                bio,
                -1,
                hourlyRate,
                averageRating,
                createdAt,
                isVerified);

        assertNull(tutorProfile);
    }

    @Test
    void createTutorProfileWithNegativeHourlyRate() {
        TutorProfile tutorProfile = TutorProfileFactory.createTutorProfile(user,
                bio,
                yearsExperience,
                new BigDecimal(-25.00),
                averageRating,
                createdAt,
                isVerified);

        assertNull(tutorProfile);
    }

    @Test
    void createTutorProfileWithNegativeRating() {
        TutorProfile tutorProfile = TutorProfileFactory.createTutorProfile(user,
                bio,
                yearsExperience,
                hourlyRate,
                -1,
                createdAt,
                isVerified);

        assertNull(tutorProfile);
    }

    @Test
    void createTutorProfileWithNullCreatedAt() {
        TutorProfile tutorProfile = TutorProfileFactory.createTutorProfile(user,
                bio,
                yearsExperience,
                hourlyRate,
                averageRating,
                null,
                isVerified);

        assertNull(tutorProfile);
    }
}
package za.ac.cput.factory;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;

public class TutorProfileFactoryTest {

    User user = new User.Builder().build();
    String bio = "Tutor profile biography";
    int yearsExperience = 2;
    double hourlyRate = 25.00;
    double averageRating = 4.3;
    LocalDateTime createdAt = LocalDateTime.now();

    private TutorProfile tutorProfile = new TutorProfileFactory().createTutorProfile(user, bio, yearsExperience,
            hourlyRate, averageRating, createdAt);

    @Test
    void createTutorProfile() {
        System.out.println(tutorProfile);
    }
}
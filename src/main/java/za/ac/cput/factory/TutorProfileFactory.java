package za.ac.cput.factory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.util.HelperUtil;

public class TutorProfileFactory {

    public static TutorProfile createTutorProfile(User user,
            String bio,
            int yearsExperience,
            BigDecimal hourlyRate,
            double averageRating,
            LocalDateTime createdAt,
            boolean isVerified) {

        if (user == null ||
                !HelperUtil.isZeroOrPositiveInteger(yearsExperience) ||
                !HelperUtil.isZeroOrPositiveBigDecimal(hourlyRate) ||
                !HelperUtil.isPositiveDouble(averageRating) ||
                createdAt == null) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return TutorProfile.builder()
                .tutorProfileId(id)
                .user(user)
                .bio(bio)
                .yearsExperience(yearsExperience)
                .hourlyRate(hourlyRate)
                .averageRating(averageRating)
                .createdAt(createdAt)
                .isVerified(isVerified)
                .build();
    }
}
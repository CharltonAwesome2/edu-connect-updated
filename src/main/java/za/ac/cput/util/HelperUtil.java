package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.UUID;

public class HelperUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static boolean isNullOrEmpty(String inputString) {
        return inputString == null || inputString.isEmpty();
    }

    public static boolean isValidEmail(String inputEmail) {
        EmailValidator emailValidator = EmailValidator.getInstance();

        return emailValidator.isValid(inputEmail);
    }

    public static Long generateId() {
        // return UUID.randomUUID();
        return Math.abs(UUID.randomUUID().getMostSignificantBits());
    }

    public static boolean isPositiveDouble(double inputDouble) {
        return inputDouble > 0;
    }

    public static boolean isZeroOrPositiveInteger(int inputInteger) {
        return inputInteger >= 0;
    }

    public static boolean isValidRating(double rating) {
        return rating >= 0 & rating <= 5;
    }

    public static String hashPassword(String password) {
        return encoder.encode(password);
    }

    public static boolean verifyPassword(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }

    public static String extractSalt(String hash) {
        return hash.substring(7, 29);
    }

    public static boolean isZeroOrPositiveBigDecimal(BigDecimal inputBigDecimal) {
        return inputBigDecimal != null && inputBigDecimal.intValue() >= 0;
    }

    /*
    Valid:
    rating
    date
    status?
    money amount?
    time?
    */

    // ENUM status?
}

package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;
import za.ac.cput.util.HelperUtil;

import java.time.LocalDateTime;

/**
 * userAuthFactory.java
 * Factory class for creating UserAuth objects
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 06 August 2026
 */

public class userAuthFactory {
    public static UserAuth createUserAuth(String password, User user) {

        if (!HelperUtil.isNullOrEmpty(password)) {
            return null;
        }

        if (user == null) {
            return null;
        }

        String hashedPassword = HelperUtil.hashPassword(password);

        return new UserAuth.Builder()
                .setAuthId(HelperUtil.generateId())
                .passwordHash(hashedPassword)
                .setLastLogin(LocalDateTime.now())
                .setUser(user)
                .build();
    }
}

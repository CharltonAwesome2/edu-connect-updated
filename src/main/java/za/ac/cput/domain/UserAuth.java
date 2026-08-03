package za.ac.cput.domain;

import java.time.LocalDateTime;

/**
 * UserAuth.java
 * UserAuth model class
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */

public class UserAuth {
    private Long authId;
    private String passwordHash;
    private LocalDateTime lastLogin;
    private User user;

    private UserAuth(Builder builder) {
        this.authId = builder.authId;
        this.passwordHash = builder.setPasswordHash;
        this.lastLogin = builder.lastLogin;
        this.user = builder.user;
    }

    public Long getAuthId() {
        return authId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public User getUser() {
        return user;
    }


    @Override
    public String toString() {
        return "UserAuth [authId=" + authId + ", passwordHash=" + passwordHash + ", lastLogin="
                + lastLogin + ", user=" + user + "]";
    }

    public static class Builder {
        private Long authId;
        private String setPasswordHash;
        private LocalDateTime lastLogin;
        private User user;

        public Builder setAuthId(Long authId) {
            this.authId = authId;
            return this;
        }

        public Builder passwordHash(String passwordHash) {
            this.setPasswordHash = passwordHash;
            return this;
        }


        public Builder setLastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(UserAuth userAuth) {
            this.authId = userAuth.authId;
            this.setPasswordHash = userAuth.passwordHash;
            this.lastLogin = userAuth.lastLogin;
            this.user = userAuth.user;
            return this;
        }

        public UserAuth build() {
            return new UserAuth(this);
        }
    }
}

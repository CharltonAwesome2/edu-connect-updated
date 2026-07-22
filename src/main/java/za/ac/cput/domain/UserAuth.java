package za.ac.cput.domain;

import java.time.LocalDateTime;

/**
 * UserAuth.java
 * UserAuth model class
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */

public class UserAuth {
    private long authId;
    private String passwordHash;
    private LocalDateTime lastLogin;
    private Long userId;

    private UserAuth(Builder builder) {
        this.authId = builder.authId;
        this.passwordHash = builder.setPasswordHash;
        this.lastLogin = builder.lastLogin;
        this.userId = builder.userId;
    }

    public long getAuthId() {
        return authId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public Long getUserId() {
        return userId;
    }


    @Override
    public String toString() {
        return "UserAuth [authId=" + authId + ", passwordHash=" + passwordHash + ", lastLogin="
                + lastLogin + ", userId=" + userId + "]";
    }

    public static class Builder {
        private long authId;
        private String setPasswordHash;
        private LocalDateTime lastLogin;
        private Long userId;

        public Builder setAuthId(long authId) {
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

        public Builder setUser(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder copy(UserAuth userAuth) {
            this.authId = userAuth.authId;
            this.setPasswordHash = userAuth.passwordHash;
            this.lastLogin = userAuth.lastLogin;
            this.userId = userAuth.userId;
            return this;
        }

        public UserAuth build() {
            return new UserAuth(this);
        }
    }
}

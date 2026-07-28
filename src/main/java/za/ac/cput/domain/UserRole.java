package za.ac.cput.domain;

/*
    UserRole.java
    UserRole model class
    Author: Charlton Solomons (220483418)
    Date: 17 July 2026
*/

public class UserRole {
    private Long id;
    private Role role;
    private User user;

    private UserRole(Builder builder) {
        this.id = builder.id;
        this.role = builder.role;
        this.user = builder.user;
    }

    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserRole [id=" + id + ", role=" + role + ", user=" + user + "]";
    }

    public static class Builder {
        private Long id;
        private Role role;
        private User user;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(UserRole userRole) {
            this.id = userRole.id;
            this.role = userRole.role;
            this.user = userRole.user;
            return this;
        }

        public UserRole build() {
            return new UserRole(this);
        }

    }
}

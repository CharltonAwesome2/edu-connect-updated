package za.ac.cput.domain;

/*
    Role.java
    Role model class
    Author: Charlton Solomons (220483418)
    Date: 17 July 2026
*/

public class Role {

    private Long id;
    private String roleName;
    private String description;

    private Role(Builder builder) {
        this.id = builder.id;
        this.roleName = builder.roleName;
        this.description = builder.description;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Role [roleId=" + id + ", roleName=" + roleName + ", description=" + description + "]";
    }

    public static class Builder {

        private Long id;
        private String roleName;
        private String description;

        public Builder setId(Long id){
            this.id = id;
            return this;
        }

        public Builder setRoleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Role role) {
            this.id = role.id;
            this.roleName = role.roleName;
            this.description = role.description;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}

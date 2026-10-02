package za.ac.cput.factory;


import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Role;

public class RoleFactoryTest {

    String roleName = "Tutor";
    String description = "Tutor for subjects";

    private Role role = RoleFactory.createRole(roleName, description);

    @Test
    void createRole() {
        System.out.println(role);
    }
}

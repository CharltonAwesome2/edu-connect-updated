package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Role;

public class RoleFactoryTest {

    String roleName = "Tutor";
    String description = "Tutor for subjects";

    @Test
    void createRole() {
        Role role = RoleFactory.createRole(roleName, description);

        assertNotNull(role);
        assertNotNull(role.getId());
        assertEquals(roleName, role.getRoleName());
        assertEquals(description, role.getDescription());
    }

    @Test
    void createRoleWithEmptyRoleName() {
        Role role = RoleFactory.createRole("", description);
        assertNull(role);
    }

    @Test
    void createRoleWithNullRoleName() {
        Role role = RoleFactory.createRole(null, description);
        assertNull(role);
    }

    @Test
    void createRoleWithEmptyDescription() {
        Role role = RoleFactory.createRole("", description);
        assertNull(role);
    }

    @Test
    void createRoleWithNullDescription() {
        Role role = RoleFactory.createRole(null, description);
        assertNull(role);
    }
}

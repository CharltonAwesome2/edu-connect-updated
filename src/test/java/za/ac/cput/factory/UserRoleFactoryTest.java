package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserRole;

public class UserRoleFactoryTest {

    User user = User.builder()
            .userId(1L)
            .name("John")
            .surname("Doe").build();

    Role role = Role.builder()
            .roleId(2L)
            .roleName("Student")
            .description("Student user role").build();

    @Test
    void createUserRole() {
        UserRole userRole = UserRoleFactory.creatUserRole(role, user);

        assertNotNull(userRole);
        assertNotNull(userRole.getUserRoleId());
        assertEquals(user, userRole.getUser());
        assertEquals(role, userRole.getRole());
    }

    @Test
    void createUserRoleWithNullRole() {
        UserRole userRole = UserRoleFactory.creatUserRole(null, user);
        assertNull(userRole);

    }

    @Test
    void createUserRoleWithNullUser() {
        UserRole userRole = UserRoleFactory.creatUserRole(role, null);
        assertNull(userRole);

    }
}

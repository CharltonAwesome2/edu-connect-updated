package za.ac.cput.factory;


import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserRole;

public class UserRoleFactoryTest { 

    User user = new User.Builder().build();
    Role role = new Role.Builder().build();

    private UserRole userRole = UserRoleFactory.creatUserRole(role, user);
    
    @Test
    void createUserRole(){
        System.out.println(userRole);
    }
}

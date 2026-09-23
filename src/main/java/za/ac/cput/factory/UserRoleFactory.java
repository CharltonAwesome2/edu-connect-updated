package za.ac.cput.factory;

import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserRole;
import za.ac.cput.util.HelperUtil;

public class UserRoleFactory {

    public static UserRole creatUserRole(Role role, User user) {
        
        if (role == null || user == null) {
            return null;
        }

        Long id = HelperUtil.generateId();

        return new UserRole.Builder()
                .setId(id)
                .setRole(role)
                .setUser(user).build();
    }
}

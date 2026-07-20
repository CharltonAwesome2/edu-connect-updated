package za.ac.cput.factory;

import za.ac.cput.domain.Role;
import za.ac.cput.util.HelperUtil;

public class RoleFactory {
    public static Role createRole(String roleName, String description) {

        if (HelperUtil.isNullOrEmpty(roleName) || HelperUtil.isNullOrEmpty(description)) {
            return null;
        }

        Long id = HelperUtil.generateId();
        
        return new Role.Builder()
                .setId(id)
                .setRoleName(roleName)
                .setDescription(description)
                .build();
    }
}
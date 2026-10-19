package za.ac.cput.domain;

import lombok.Builder;
import lombok.Data;

/*
    UserRole.java
    UserRole model class
    Author: Charlton Solomons (220483418)
    Date: 17 July 2026
*/

@Data 
@Builder
public class UserRole {

    private Long userRoleId;
    private Role role;
    private User user;
    
}

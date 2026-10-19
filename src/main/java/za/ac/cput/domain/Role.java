package za.ac.cput.domain;

import lombok.Builder;
import lombok.Data;

/*
    Role.java
    Role model class
    Author: Charlton Solomons (220483418)
    Date: 17 July 2026
*/

@Data
@Builder
public class Role {

    private Long roleId;
    private String roleName;
    private String description;

}

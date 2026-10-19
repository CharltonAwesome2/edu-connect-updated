package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
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
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    private Role role;
    private User user;

}

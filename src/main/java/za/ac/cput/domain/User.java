package za.ac.cput.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

/**
 * User.java
 * User model class
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */

@Data 
@Builder
public class User {

    private Long userId;
    private String name;
    private String surname;
    private String studentNumber;
    private String email;
    private String contactNumber;
    private LocalDateTime createdAt;
    private Boolean isTutor;
    private Boolean isStudent;
    
}

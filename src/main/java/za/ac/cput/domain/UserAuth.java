package za.ac.cput.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

/**
 * UserAuth.java
 * UserAuth model class
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */

@Data 
@Builder
public class UserAuth {

    private Long userAuthId;
    private User user;
    private String passwordHash;
    private LocalDateTime lastLogin;
    
}

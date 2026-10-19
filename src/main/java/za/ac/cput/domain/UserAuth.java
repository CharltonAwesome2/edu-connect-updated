package za.ac.cput.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
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
@Entity
@Table(name = "user_auth")
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAuthId;

    private User user;
    private String passwordHash;
    private LocalDateTime lastLogin;

}

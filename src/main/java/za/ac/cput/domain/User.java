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
 * User.java
 * User model class
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */

@Data 
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

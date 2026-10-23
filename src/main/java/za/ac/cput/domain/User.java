package za.ac.cput.domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User.java
 * User model class
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
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

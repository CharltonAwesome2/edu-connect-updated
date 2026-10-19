package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}

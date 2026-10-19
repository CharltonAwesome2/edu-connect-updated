package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

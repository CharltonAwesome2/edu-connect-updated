package za.ac.cput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import za.ac.cput.domain.UserRole;
import za.ac.cput.repository.UserRoleRepository;

public class UserRoleService implements service<UserRole, Long> {

    private final UserRoleRepository userRoleRepository;

    @Autowired 
    UserRoleService(UserRoleRepository userRoleRepository){
        this.userRoleRepository = userRoleRepository;
    }
    @Override
    public UserRole create(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole read(Long id) {
        return userRoleRepository.findById(id).orElse(null);
    }

    @Override
    public UserRole update(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void delete(Long id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public List<UserRole> getAll() {
       return userRoleRepository.findAll();
    }

}

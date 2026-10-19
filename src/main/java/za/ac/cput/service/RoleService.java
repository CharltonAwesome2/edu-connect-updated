package za.ac.cput.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import za.ac.cput.domain.Role;
import za.ac.cput.repository.RoleRepository;

public class RoleService implements service<Role, Long> {

    private final RoleRepository roleRepository;

    @Autowired
    RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {

        if (role == null){
            return null;
        }

        return roleRepository.save(role);
    }

    @Override
    public Role read(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role update(Role role) {

        if (role == null){
            return null;
        }
        
        return roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

}

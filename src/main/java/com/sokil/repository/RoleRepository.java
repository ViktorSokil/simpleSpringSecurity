package com.sokil.repository;

import com.sokil.entity.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findByRole(String role);
}

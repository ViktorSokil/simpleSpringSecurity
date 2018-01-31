package com.sokil.repository;


import com.sokil.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
    List<User> findAll();

}

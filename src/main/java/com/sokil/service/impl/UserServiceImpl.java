package com.sokil.service.impl;

import com.sokil.repository.UserRepository;
import com.sokil.entity.User;
import com.sokil.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository userDAO;

    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public User findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }
}

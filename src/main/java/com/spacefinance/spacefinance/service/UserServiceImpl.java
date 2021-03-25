package com.spacefinance.spacefinance.service;


import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.model.User;
import com.spacefinance.spacefinance.repository.ParagonDao;
import com.spacefinance.spacefinance.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userRepository;
    @Autowired
    ParagonDao paragonRepository;

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Paragon> allParagon() {
        return paragonRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        this.userRepository.save(user);
    }
}

package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    List<Paragon> allParagon();
    void addUser(User user);

}

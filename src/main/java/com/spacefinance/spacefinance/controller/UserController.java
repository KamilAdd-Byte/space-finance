package com.spacefinance.spacefinance.controller;//package com.paragons.demo.controller;

import com.spacefinance.spacefinance.model.User;
import com.spacefinance.spacefinance.repository.UserDao;
import com.spacefinance.spacefinance.service.ParagonService;
import com.spacefinance.spacefinance.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserDao userRepository;
    private final UserService userService;
    private final ParagonService paragonService;

    public UserController(UserDao userRepository, UserService userService, ParagonService paragonService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.paragonService = paragonService;
    }

    @GetMapping("/showNewUserForm")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "new_user";
    }
}

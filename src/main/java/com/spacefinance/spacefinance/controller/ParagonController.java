package com.spacefinance.spacefinance.controller;



import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.model.User;
import com.spacefinance.spacefinance.repository.UserDao;
import com.spacefinance.spacefinance.service.ParagonService;
import com.spacefinance.spacefinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParagonController {

    private final UserDao userRepository;
    private final UserService userService;
    private final ParagonService paragonService;

    @Autowired
    public ParagonController(UserDao userRepository, UserService userService, ParagonService paragonService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.paragonService = paragonService;
    }


    @GetMapping("/paragon_info")
    public String allUser(Model model) {
        Paragon paragon = new Paragon();
        model.addAttribute("paragon", paragon);
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("listParagons", userService.allParagon());
        return "paragon_info";
    }

    @GetMapping("/paragon")
    public String saveUser(Model model) {
        model.addAttribute("listAllParagon", userService.allParagon());
        return "paragon";
    }

    @PostMapping("/save_paragon")
    public String saveParagon(@ModelAttribute("paragon") Paragon paragon, @ModelAttribute("user") User user,
                              Model model) {
        User save = userRepository.save(user);
        paragonService.saveParagon(save, paragon);
        model.addAttribute("message", "Dodano paragon!");
        return "redirect:/paragon";
    }

//    @GetMapping("/sum")
//    public String sumReport(Model model) {
//        model.addAttribute("kam", paragonService.getSumUserParagon());
//        model.addAttribute("sum", paragonService.sumAllParagon());
//        model.addAttribute("kas", paragonService.getSumUserKasiaParagon());
//        return "sum";
//    }

//    @GetMapping("/remove/{id}")
//    public String removeParagonById(@PathVariable("id") Long id, Model model) {
//        Paragon paragonById = paragonService.findParagonById(id);
//        model.addAttribute("message", "Usunięto pomyślnie!");
//        paragonService.removeParagonById(id, paragonById);
//        return "redirect:/paragon";
//    }
//
//    @GetMapping("/update/{id}")
//    public String updateParagonById(@PathVariable("id") Long id, @ModelAttribute("user") User user, Model model) {
//        Paragon paragonById = paragonService.findParagonById(id);
//        model.addAttribute("message", "Update pomyślnie!");
//        model.addAttribute("paragon", paragonById);
//        model.addAttribute("listAllUser", userService.allUsers());
//        return "paragon_update";
//    }

}

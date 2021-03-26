package com.spacefinance.spacefinance.controller;



import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.service.ParagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParagonController {

    private final ParagonService paragonService;

    @Autowired
    public ParagonController(ParagonService paragonService) {
        this.paragonService = paragonService;
    }

    @GetMapping("/paragon")
    public String allUser(Model model) {
        model.addAttribute("listAllParagon", paragonService.allParagons());
        return "paragon";
    }
     @GetMapping("/paragon_info")
    public String paragons(Model model) {
        Paragon paragon = new Paragon();
        model.addAttribute("paragon", paragon);
        model.addAttribute("allListParagon", paragonService.allParagons());
        return "paragon_info";
    }

    @PostMapping("/save_paragon")
    public String saveParagon(@ModelAttribute("paragon") Paragon paragon,
                              Model model) {
        paragonService.saveParagon(paragon);
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

    @GetMapping("/remove/{paragon}")
    public String removeParagonById(@PathVariable("paragon") Paragon paragon, Model model) {
        model.addAttribute("message", "Usunięto pomyślnie!");
        paragonService.removeParagon(paragon);
        return "redirect:/paragon";
    }
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

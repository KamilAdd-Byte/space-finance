package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.service.impl.ParagonServiceImpl;
import com.spacefinance.spacefinance.valid.impl.ServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ParagonController {

    @Autowired
    private final ParagonServiceImpl paragonService;


    public ParagonController(final ParagonServiceImpl paragonService) {
        this.paragonService = paragonService;
    }

    @GetMapping("/paragon")
    public String allUser(Model model) {
        model.addAttribute("listAllParagon", paragonService.allParagons());
        model.addAttribute("sum",paragonService.sizeParagon());
        model.addAttribute("allPrice",paragonService.getSumAllParagon());
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
    public String saveParagon(@Valid @ModelAttribute("paragon") Paragon paragon, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<ObjectError> errorList = bindingResult.getAllErrors();
            errorList.forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
            return "paragon_info";
        } else
        paragonService.saveParagon(paragon);
        return "redirect:/paragon";
    }

    @GetMapping("/paragon/remove/{paragon}")
    public String removeParagon(@PathVariable("paragon") Paragon paragon, Model model) {
        paragonService.removeParagon(paragon);
        return "redirect:/paragon";
    }

    @GetMapping("paragon/update/{id}")
    public String updateParagonById(@PathVariable("id") String id, Paragon paragon, Model model) {
        paragonService.updateParagon(id,paragon);
        model.addAttribute("message", "Update pomyślnie!");
        model.addAttribute("paragon",paragon);
        return "paragon_update";
    }
}

package com.spacefinance.spacefinance.shopspace.model.controller;

import com.spacefinance.spacefinance.shopspace.Paragon;
import com.spacefinance.spacefinance.shopspace.service.impl.ParagonServiceImpl;
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
    public String allParagonList(Model model) {
        model.addAttribute("listAllParagon", paragonService.allParagons());
        model.addAttribute("sum",paragonService.sizeParagon());
        model.addAttribute("allPrice",paragonService.getSumAllParagon());
        return "paragon";
    }
     @GetMapping("/paragon_info")
    public String addNewParagonToModel(Model model) {
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

    @GetMapping("/paragon/remove/{id}")
    public String removeParagon(@PathVariable("id") String idParagon) {
        paragonService.removeParagon(idParagon);
        return "redirect:/paragon";
    }

    @GetMapping("paragon/update/{id}")
    public String updateParagonById(@PathVariable("id") String id,Model model) {
        Paragon update = paragonService.updateParagon(id);
        model.addAttribute("paragon",update);
        return "paragon_update";
    }
}

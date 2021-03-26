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

    @Autowired
    private final ParagonService paragonService;

    public ParagonController(ParagonService paragonService) {
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
        paragonService.removeParagon(paragon);
        model.addAttribute("message", "Usunięto pomyślnie!");
        return "redirect:/paragon";
    }

    @GetMapping("/update/{id}")
    public String updateParagonById(@PathVariable("id") String id, Paragon paragon, Model model) {
        paragonService.updateParagon(id,paragon);
        model.addAttribute("message", "Update pomyślnie!");
        model.addAttribute("paragon",paragon);
        return "paragon_update";
    }
}

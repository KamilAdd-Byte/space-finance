package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.model.Travel;
import com.spacefinance.spacefinance.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TravelController {

    private final TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/travel")
    public String travel(Model model){
        model.addAttribute("allTravel",travelService.allTravel());
        return "travel";
    }
    @GetMapping("/travel_info")
    public String paragons(Model model) {
        Travel travel = new Travel();
        model.addAttribute("travel", travel);
        model.addAttribute("alltravel", travelService.allTravel());
        return "travel_info";
    }
    @PostMapping("/save_travel")
    public String saveTravel(@ModelAttribute("travel") Travel travel, Model model){
        travelService.addTravel(travel);
        model.addAttribute("pomyślnie","pomyślnie");
        return "redirect:/travel";
    }
    @GetMapping("travel/remove/{travel}")
    public String removeParagonById(@PathVariable("travel") Travel travel, Model model) {
        travelService.removeTravel(travel);
        model.addAttribute("message", "Usunięto pomyślnie!");
        return "redirect:/travel";
    }
}

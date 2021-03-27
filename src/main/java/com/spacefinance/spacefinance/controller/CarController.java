package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.model.Car;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car")
    public String allUser(Model model) {
        model.addAttribute("listAllCars", carService.allCars());
        model.addAttribute("sum",carService.sizeCars());
        model.addAttribute("allPrice",carService.getSumAllCars());
        return "car";
    }

    @GetMapping("/car_info")
    public String cars(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("allListCarsn", carService.allCars());
        return "car_info";
    }

    @PostMapping("/save_car")
    public String saveCars(@ModelAttribute("cars") Car car,
                              Model model) {
        carService.addCars(car);
        model.addAttribute("message", "Dodano rekord!");
        return "redirect:/car";
    }
     @GetMapping("/remove/{car}")
    public String removeParagonById(@PathVariable("car") Car car, Model model) {
        carService.removeParagon(car);
        model.addAttribute("message", "Usunięto pomyślnie!");
        return "redirect:/car";
    }
}

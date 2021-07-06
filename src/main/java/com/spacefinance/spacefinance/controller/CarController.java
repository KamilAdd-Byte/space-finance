package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.model.Car;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

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
        model.addAttribute("allListCar", carService.allCars());
        return "car_info";
    }

    @PostMapping("/save_car")
    public String saveCars(@Valid @ModelAttribute("cars") Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<ObjectError>errorList = bindingResult.getAllErrors();
            errorList.forEach(err -> System.out.println(err.getDefaultMessage()));
            return "car_info";
        } else
        carService.addCars(car);
        return "redirect:/car";
    }
     @GetMapping("car/remove/{car}")
    public String removeParagonById(@PathVariable("car") Car car, Model model) {
        carService.removeParagon(car);
        model.addAttribute("message", "Usunięto pomyślnie!");
        return "redirect:/car";
    }
}

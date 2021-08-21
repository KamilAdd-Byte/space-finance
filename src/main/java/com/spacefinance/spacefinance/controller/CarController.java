package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.model.Car;
import com.spacefinance.spacefinance.model.CarExpenses;
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
    public CarController(final CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/my_car")
    public String allCarExpensesList(Model model) {
        Car newCar = new Car();
        model.addAttribute("car", newCar);
        model.addAttribute("allCars", carService.allMyCars());
        return "my_car";
    }
    @PostMapping("/my_car_save")
    public String saveMyCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<ObjectError> errorList = bindingResult.getAllErrors();
            errorList.forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
            return "carExpenses";
        } else
            carService.addCar(car);
        return "redirect:/carExpenses";
    }
    @GetMapping("car/remove/{car}")
    public String removeCarById(@PathVariable("car") Car car, Model model) {
        carService.removeCar(car);
        return "redirect:/carExpenses";
    }
}

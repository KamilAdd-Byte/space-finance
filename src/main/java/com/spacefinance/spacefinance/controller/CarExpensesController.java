package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.model.Car;
import com.spacefinance.spacefinance.model.CarExpenses;
import com.spacefinance.spacefinance.service.CarExpensesService;
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
public class CarExpensesController {

    private final CarExpensesService carExpensesService;

    private final CarService carService;

    @Autowired
    public CarExpensesController(final CarExpensesService carExpensesService,final CarService carService) {
        this.carExpensesService = carExpensesService;
        this.carService = carService;
    }

    @GetMapping("/carExpenses")
    public String allCarExpensesList(Model model) {
        model.addAttribute("allCarExpenses", carExpensesService.allCarsExpenses());
        model.addAttribute("sum", carExpensesService.sizeCarsExpenses());
        model.addAttribute("allPrice", carExpensesService.getSumAllCarsExpenses());
        model.addAttribute("allCars", carService.allMyCars());
        return "carExpenses";
    }

    @GetMapping("/carExpenses_info")
    public String addNewCarExpensesToModel(Model model) {
        CarExpenses carExpenses = new CarExpenses();
        Car newCar = new Car();
        model.addAttribute("carExpenses", carExpenses);
        model.addAttribute("allCarExpenses", carExpensesService.allCarsExpenses());
        model.addAttribute("car", newCar);
        model.addAttribute("allCars", carService.allMyCars());
        return "carExpenses_info";
    }

    @PostMapping("/carExpenses_save")
    public String saveCarExpenses(@Valid @ModelAttribute("carExpenses") CarExpenses carExpenses, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<ObjectError> errorList = bindingResult.getAllErrors();
            errorList.forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
            return "carExpenses_info";
        } else
        carExpensesService.addCarsExpenses(carExpenses);
        return "redirect:/carExpenses";
    }
     @GetMapping("carExpenses/remove/{id}")
    public String removeCarsExpensesById(@PathVariable("id") String idCarExpenses, Model model) {
        carExpensesService.removeCarsExpenses(idCarExpenses);
        return "redirect:/carExpenses";
    }

    @GetMapping("carExpenses/update/{id}")
    public String updateCarExpensesById(@PathVariable("id") String id, Model model){
        CarExpenses update = carExpensesService.findCarExpensesById(id);
        model.addAttribute("carExpenses",update);
        return "carExpenses_update";
    }

}

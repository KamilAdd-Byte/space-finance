package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.model.CarExpenses;
import com.spacefinance.spacefinance.service.CarExpensesService;
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

    @Autowired
    public CarExpensesController(final CarExpensesService carExpensesService) {
        this.carExpensesService = carExpensesService;
    }

    @GetMapping("/carExpenses")
    public String allCarExpenses(Model model) {
        model.addAttribute("allCarExpenses", carExpensesService.allCarsExpenses());
        model.addAttribute("sum", carExpensesService.sizeCarsExpenses());
        model.addAttribute("allPrice", carExpensesService.getSumAllCarsExpenses());
        return "carExpenses";
    }

    @GetMapping("/carExpenses_info")
    public String addNewCarExpensesToModel(Model model) {
        CarExpenses carExpenses = new CarExpenses();
        model.addAttribute("carExpenses", carExpenses);
        model.addAttribute("allCarExpenses", carExpensesService.allCarsExpenses());
        return "carExpenses_info";
    }

    @PostMapping("/carExpenses_save")
    public String saveCarsExpenses(@Valid @ModelAttribute("car") CarExpenses carExpenses, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<ObjectError> errorList = bindingResult.getAllErrors();
            errorList.forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
            return "carExpenses_info";
        } else
        carExpensesService.addCarsExpenses(carExpenses);
        return "redirect:/carExpenses";
    }
     @GetMapping("carExpenses/remove/{car}")
    public String removeCarsExpensesById(@PathVariable("car") CarExpenses carExpenses, Model model) {
        carExpensesService.removeCarsExpenses(carExpenses);
        return "redirect:/carExpenses";
    }

    @GetMapping("carExpenses/update/{id}")
    public String updateCarExpensesById(@PathVariable("id") String id, Model model){
        CarExpenses update = carExpensesService.findCarExpensesById(id);
        model.addAttribute("carExpenses",update);
        return "carExpenses_update";
    }

}

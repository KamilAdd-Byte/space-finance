package com.spacefinance.spacefinance.carspace.controller;

import com.spacefinance.spacefinance.carspace.CarExpenses;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@Service
public interface CarExpensesController {
    String allCarExpensesList(Model model);
    String addNewCarExpensesToModel(Model model);
    String saveCarExpenses(@Valid @ModelAttribute("carExpenses") CarExpenses carExpenses, BindingResult bindingResult);
    String removeCarsExpensesById(@PathVariable("id") String idCarExpenses, Model model);
    String updateCarExpensesById(@PathVariable("id") String id, Model model);
}

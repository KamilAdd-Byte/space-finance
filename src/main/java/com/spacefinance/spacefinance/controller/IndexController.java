package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.service.FinanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final FinanceModel financeModel;

    @Autowired
    public IndexController(FinanceModel financeModel) {
        this.financeModel = financeModel;
    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("all",financeModel.sizeListAllOperation());
        model.addAttribute("sumAll",financeModel.allExpenditure());
        return "index";
    }
    @GetMapping("/index")
    public String get(Model model){
        model.addAttribute("all",financeModel.sizeListAllOperation());
        model.addAttribute("sumAll",financeModel.allExpenditure());
        return "index";
    }
}

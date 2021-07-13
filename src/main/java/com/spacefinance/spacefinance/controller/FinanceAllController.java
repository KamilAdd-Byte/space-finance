package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.service.FinanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FinanceAllController {

    private final FinanceModel financeModel;

    @Autowired
    public FinanceAllController(FinanceModel financeModel) {
        this.financeModel = financeModel;
    }

    @GetMapping("/finance")
    public String myExpensesAllSummary(Model model){
        model.addAttribute("all",financeModel.sizeListAllOperation());
        model.addAttribute("sumAll",financeModel.allExpenditure());
        return "finance";
    }

    @GetMapping("/finance/name")
    public String getOneExpensesUser (Model model) {
        model.addAttribute("name",financeModel.oneExpenses("KASIA"));
        return "finance";
    }
}

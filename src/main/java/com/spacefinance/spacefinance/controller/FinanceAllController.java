package com.spacefinance.spacefinance.controller;

import com.spacefinance.spacefinance.service.FinanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/finance/kamil")
    public String getOneExpensesUserKamil (Model model) {
        model.addAttribute("month",financeModel.monthKamilExpenses());
        return "finance";
    }
}

package com.spacefinance.spacefinance.shopspace.finance.controller;

import com.spacefinance.spacefinance.shopspace.finance.service.FinanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinanceAllController {

    private final FinanceModel financeModel;

    @Autowired
    public FinanceAllController(final FinanceModel financeModel) {
        this.financeModel = financeModel;
    }

    @GetMapping("/finance")
    public String myExpensesAllSummary(Model model){
        model.addAttribute("all",financeModel.sizeListAllOperation());
        model.addAttribute("sumAll",financeModel.allExpenditure());
        model.addAttribute("expensesKamil",financeModel.allExpensesUserKamil());
        model.addAttribute("expensesKasia",financeModel.allExpensesUserKasia());
        return "finance";
    }
}

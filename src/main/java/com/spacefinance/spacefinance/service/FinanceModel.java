package com.spacefinance.spacefinance.service;

import org.springframework.stereotype.Service;

@Service
public interface FinanceModel {
    int sumAllExpenditure();
    double allExpenditure();
}
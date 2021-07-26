package com.spacefinance.spacefinance.service;

import org.springframework.stereotype.Service;

import java.time.Month;

@Service
public interface FinanceModel {

    int sizeListAllOperation();

    double allExpenditure();

    double allExpensesUserKamil();

    double allExpensesUserKasia();

    double getSumOnMonthUserKamil();
}

package com.spacefinance.spacefinance.shopspace.finance.service;

import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.stereotype.Service;

import java.time.Month;

@Service
public interface FinanceModel {

    int sizeListAllOperation();

    double allExpenditure();

    double allExpensesUserKamil();

    double allExpensesUserKasia();

    double getSumOnMonthUserKamil(Month month);
}

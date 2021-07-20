package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.CarExpenses;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CarExpensesService {
    List<CarExpenses> allCarsExpenses();
    void addCarsExpenses(CarExpenses carExpenses);
    void removeCarsExpenses(CarExpenses carExpenses);
    int sizeCarsExpenses();
    double getSumAllCarsExpenses();
}

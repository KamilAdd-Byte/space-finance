package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.CarExpenses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarExpensesService {
    List<CarExpenses> allCarsExpenses();

    void addCarsExpenses(CarExpenses carExpenses);

    void removeCarsExpenses(String idCarExpenses);

    CarExpenses findCarExpensesById(String id);

    CarExpenses updateCarExpensesById(String id);

    int sizeCarsExpenses();

    double getSumAllCarsExpenses();
}

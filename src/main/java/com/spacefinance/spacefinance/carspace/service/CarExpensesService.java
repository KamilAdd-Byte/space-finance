package com.spacefinance.spacefinance.carspace.service;

import com.spacefinance.spacefinance.carspace.CarExpenses;
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

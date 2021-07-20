package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.model.CarExpenses;
import com.spacefinance.spacefinance.repository.CarExpensesDao;
import com.spacefinance.spacefinance.service.CarExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarExpensesServiceImpl implements CarExpensesService {

   @Autowired
   private CarExpensesDao carRepository;

    @Override
    public List<CarExpenses> allCarsExpenses() {
        return carRepository.findAll();
    }

    @Override
    public void addCarsExpenses(CarExpenses carExpenses) {
        try {
            this.carRepository.save(carExpenses);
        }catch (IllegalArgumentException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void removeCarsExpenses(CarExpenses carExpenses) {
        this.carRepository.delete(carExpenses);
    }

    @Override
    public int sizeCarsExpenses() {
        List<CarExpenses> carExpans = carRepository.findAll();
        return carExpans.size();
    }

    @Override
    public double getSumAllCarsExpenses() {
        double price = 0.0;
        List<CarExpenses> carsExpenses = carRepository.findAll();
        for (CarExpenses carExpenses : carsExpenses) {
            price += carExpenses.getPrice();
        }
        return price;
    }
}
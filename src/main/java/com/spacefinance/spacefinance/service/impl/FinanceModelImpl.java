package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.model.Car;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.repository.CarDao;
import com.spacefinance.spacefinance.repository.ParagonDao;
import com.spacefinance.spacefinance.service.FinanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinanceModelImpl implements FinanceModel {
    @Autowired
    private ParagonDao paragonRepository;

    @Autowired
    private CarDao carRepository;

    /**
     * @apiNote CarModel and ParagonModel (sizeListAllOperation) 'sizeListAllOperation' it's size two list
     * @return size two list and sum Car expenses and Paragon expenses.
     */

    @Override
    public int sizeListAllOperation() {
        int total = 0;
        List<Paragon> paragons = paragonRepository.findAll();
        List<Car> fuel = carRepository.findAll();
        int sizeParagon = paragons.size();
        int sizeFuel = fuel.size();
        return total + sizeFuel + sizeParagon;
    }

    @Override
    public double allExpenditure() {
        double total = 0.0;
        List<Paragon> paragons = paragonRepository.findAll();
        for (Paragon paragon : paragons) {
            total += paragon.getPrice();
        }
        List<Car> fuel = carRepository.findAll();
        for (Car car : fuel) {
            total += car.getPrice();
        }
        return total;
    }

    @Override
    public double oneExpenses(String user) {
        double expensesOne = 0;
        List<Paragon> paragons = paragonRepository.findAll();
        for (Paragon paragon : paragons) {
            String my = paragon.getUser();
            if (my.equals(user)) {
                for (Paragon userExpenses : paragons) {
                    double expenses = userExpenses.getPrice();
                    expenses += expensesOne;
                    expensesOne++;
                }
            }
        }
        return expensesOne;
    }
}


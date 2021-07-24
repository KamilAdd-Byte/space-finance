package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.model.CarExpenses;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.repository.CarExpensesDao;
import com.spacefinance.spacefinance.repository.ParagonDao;
import com.spacefinance.spacefinance.service.FinanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinanceModelImpl implements FinanceModel {

    @Autowired
    private ParagonDao paragonRepository;

    @Autowired
    private CarExpensesDao carRepository;

    /**
     * @apiNote CarModel and ParagonModel (sizeListAllOperation) 'sizeListAllOperation' it's size two list
     * @return size two list and sum CarExpenses expenses and Paragon expenses.
     */
    @Override
    public int sizeListAllOperation() {
        int total = 0;
        List<Paragon> paragons = paragonRepository.findAll();
        List<CarExpenses> fuel = carRepository.findAll();
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
        List<CarExpenses> fuel = carRepository.findAll();
        for (CarExpenses carExpenses : fuel) {
            total += carExpenses.getPrice();
        }
        return total;
    }

    @Override
    public double monthKamilExpenses() {
        double expensesOne = 0;
        List<Paragon> paragons = paragonRepository.findAll();
        for (Paragon paragon : paragons) {
            String kamil = paragon.getUser();
            if (kamil.equals("KAMIL")){
                double v = paragon.getPrice();
                expensesOne += v;
            }
        }
        return expensesOne;
    }


    @Override
    public double getSumOnMonth() {
        List<Paragon> paragons = paragonRepository.findAll();
        paragons.stream()
                .filter(c -> c.getUser().equals("KAMIL"))
                .map(c -> c.getPrice() + " " + c.getDate())
                .collect(Collectors.toList());
        return 0.0;
    }
}


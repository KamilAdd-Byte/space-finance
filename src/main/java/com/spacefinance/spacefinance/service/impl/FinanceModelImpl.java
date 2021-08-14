package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.model.CarExpenses;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.repository.CarExpensesDao;
import com.spacefinance.spacefinance.repository.ParagonDao;
import com.spacefinance.spacefinance.service.FinanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

@Service
public class FinanceModelImpl implements FinanceModel {

    @Autowired
    private ParagonDao paragonRepository;

    @Autowired
    private CarExpensesDao carRepository;

    /**
     * @apiNote CarModel and ParagonModel (sizeListAllOperation) 'sizeListAllOperation' it's size two list
     * @return size two list and sum Car expenses and Paragon expenses.
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
    public double allExpensesUserKamil() {
        double expensesKamil = 0;
        List<Paragon> paragons = paragonRepository.findAll();
        for (Paragon paragon : paragons) {
            String kamil = paragon.getUser();
            if (kamil.equals("KAMIL")){
                double v = paragon.getPrice();
                expensesKamil += v;
            }
        }
        List<CarExpenses> carExpenses = carRepository.findAll();
        for (CarExpenses carExpens : carExpenses) {
            String kamil = carExpens.getUser();
            if (kamil.equals("KAMIL")){
                double price = carExpens.getPrice();
                expensesKamil+=price;
            }
        }
        return expensesKamil;
    }

    @Override
    public double allExpensesUserKasia() {
        double expensesKasia = 0;
        List<Paragon> paragons = paragonRepository.findAll();
        for (Paragon paragon : paragons) {
            String kasia = paragon.getUser();
            if (kasia.equals("KASIA")){
                double v = paragon.getPrice();
                expensesKasia += v;
            }
        }
        List<CarExpenses> carExpenses = carRepository.findAll();
        for (CarExpenses carExpens : carExpenses) {
            String kasia = carExpens.getUser();
            if (kasia.equals("KASIA")){
                double price = carExpens.getPrice();
                expensesKasia+=price;
            }
        }
        return expensesKasia;
    }


    @Override
    public double getSumOnMonthUserKamil(Month month) {
        double expensesKamil = 0;
        List<Paragon> paragons = paragonRepository.findAll();
        for (Paragon paragon : paragons) {
            if (paragon.getDate().equals(month) && paragon.getUser().equals("KAMIL")){
                double price = paragon.getPrice();
                expensesKamil+=price;
            }
        }
        return expensesKamil;
    }
}


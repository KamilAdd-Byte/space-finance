package com.spacefinance.spacefinance.service.impl;

import com.spacefinance.spacefinance.model.Car;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.repository.CarDao;
import com.spacefinance.spacefinance.repository.ParagonDao;
import com.spacefinance.spacefinance.service.FinanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceModelImpl implements FinanceModel {
    @Autowired
    private ParagonDao paragonRepository;

    @Autowired
    private CarDao carRepository;

    /**
     * @apiNote Fuel and Paragon(sizeListAllOperation) size it's size two list
     * @return size two list and sum Fuel and Paragon getPrice()
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
}


package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Car;
import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.repository.CarDao;
import com.spacefinance.spacefinance.repository.ParagonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceModelImpl implements FinanceModel {
    @Autowired
    private ParagonDao paragonRepository;

    @Autowired
    private CarDao carDao;

    @Override
    public int sumAllExpenditure() {
        int total = 0;
        List<Paragon> paragons = paragonRepository.findAll();
        List<Car> fuel = carDao.findAll();
        int sizeP = paragons.size();
        int sizeF = fuel.size();
        return total + sizeF + sizeP;
    }

    @Override
    public double allExpenditure() {
        double total = 0.0;
        List<Paragon> paragons = paragonRepository.findAll();
        for (Paragon paragon : paragons) {
            total += paragon.getPrice();
        }
        List<Car> fuel = carDao.findAll();
        for (Car car : fuel) {
            total+=car.getPrice();
        }
        return total;
    }

}


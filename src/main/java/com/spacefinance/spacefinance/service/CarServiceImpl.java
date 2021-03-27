package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Car;
import com.spacefinance.spacefinance.repository.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

   @Autowired
   private CarDao carRepository;

    @Override
    public List<Car> allCars() {
        return carRepository.findAll();
    }

    @Override
    public void addCars(Car car) {
        this.carRepository.save(car);
    }

    @Override
    public void removeParagon(Car car) {
        this.carRepository.delete(car);
    }

    @Override
    public int sizeCars() {
        List<Car> cars = carRepository.findAll();
        return cars.size();
    }

    @Override
    public double getSumAllCars() {
        double price = 0.0;
        List<Car> cars = carRepository.findAll();
        for (Car car : cars) {
            price += car.getPrice();
        }
        return price;
    }
}

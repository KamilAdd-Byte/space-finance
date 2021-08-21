package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> allMyCars();
    void addCar (Car myCar);
    void removeCar(Car myCar);
    Car findById(String id);
    Car updateCar(String id);
}

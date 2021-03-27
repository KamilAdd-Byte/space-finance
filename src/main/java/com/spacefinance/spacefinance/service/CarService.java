package com.spacefinance.spacefinance.service;

import com.spacefinance.spacefinance.model.Car;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CarService {
    List<Car> allCars();
    void addCars(Car car);
    void removeParagon(Car car);
    int sizeCars();
    double getSumAllCars();
}

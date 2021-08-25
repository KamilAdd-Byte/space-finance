package com.spacefinance.spacefinance.rest;

import com.spacefinance.spacefinance.interf.CarRest;
import com.spacefinance.spacefinance.model.Car;
import com.spacefinance.spacefinance.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarRestImpl implements CarRest {
    private final CarService carService;

    public CarRestImpl(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    ResponseEntity<List<Car>> getAllCarInfo() {
        List<Car> cars = carService.allMyCars();
        return ResponseEntity.ok().body(cars);
    }
}

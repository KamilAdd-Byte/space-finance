package com.spacefinance.spacefinance.carspace.cars.controller.rest.impl;

import com.spacefinance.spacefinance.carspace.cars.Car;
import com.spacefinance.spacefinance.carspace.cars.controller.rest.CarRest;
import com.spacefinance.spacefinance.carspace.cars.repository.stub.CarsServiceStub;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarRestImpl implements CarRest {
    private CarsServiceStub carService;

    @GetMapping("/cars")
    ResponseEntity<List<Car>> getAllCarInfo() {
        List<Car> cars = carService.getAllIsAccidentalCars();
        return ResponseEntity.ok().body(cars);
    }
}

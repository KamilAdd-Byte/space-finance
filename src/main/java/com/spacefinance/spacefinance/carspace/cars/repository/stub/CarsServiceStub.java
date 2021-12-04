package com.spacefinance.spacefinance.carspace.cars.repository.stub;

import com.spacefinance.spacefinance.carspace.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarsServiceStub {
    private final CarsRepositoryStub carsRepositoryStub;

    public CarsServiceStub(CarsRepositoryStub carsRepositoryStub) {
        this.carsRepositoryStub = carsRepositoryStub;
    }

    /**
     * @return list all cars which are accidental
     */
    public List<Car> getAllIsAccidentalCars(){
        return carsRepositoryStub.getAllCars().stream()
                .filter(Car::isAccidental)
                .collect(Collectors.toList());
    }
}

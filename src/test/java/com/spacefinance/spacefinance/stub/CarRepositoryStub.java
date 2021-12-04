package com.spacefinance.spacefinance.stub;

import com.spacefinance.spacefinance.carspace.cars.Car;
import com.spacefinance.spacefinance.carspace.cars.repository.stub.CarsRepositoryStub;

import java.util.Arrays;
import java.util.List;

public class CarRepositoryStub implements CarsRepositoryStub {

    @Override
    public List<Car> getAllCars() {
        Car car = createNewCar();
        Car car2 = createMoreCar();
        Car car3 = createOneMoreCar();
        return Arrays.asList(car,car2,car3);
    }

    private Car createMoreCar() {
        Car car = new Car();
        car.setModel("Btw");
        car.setCarRegistration("WW7432");
        car.setMileage(289000.9);
        car.setAccidental(true);
        return car;
    }

    private Car createOneMoreCar() {
        Car car = new Car();
        car.setModel("Opel");
        car.setCarRegistration("PO767q");
        car.setMileage(234000.9);
        car.setAccidental(false);
        return car;
    }

    private Car createNewCar() {
        Car car = new Car();
        car.setModel("GTO");
        car.setCarRegistration("PO3217");
        car.setMileage(450000.9);
        car.setAccidental(true);
        return car;
    }
}

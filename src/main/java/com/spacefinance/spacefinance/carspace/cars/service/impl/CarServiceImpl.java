package com.spacefinance.spacefinance.carspace.cars.service.impl;

import com.spacefinance.spacefinance.carspace.cars.Car;
import com.spacefinance.spacefinance.carspace.cars.repository.CarDao;
import com.spacefinance.spacefinance.carspace.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

   @Autowired
   private CarDao carRepository;

    @Override
    public List<Car> allMyCars() {
     return this.carRepository.findAll();
    }

    @Override
    public void addCar(Car myCar) {
        if (myCar!=null){
            this.carRepository.save(myCar);
        }else
            throw new NullPointerException();
    }

    @Override
    public void removeCar(Car myCar) {
        this.carRepository.delete(myCar);
    }

    @Override
    public Car findById(String id) {
        return this.carRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Car updateCar(String id) {
        Car update = this.carRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return this.carRepository.save(update);
    }
}

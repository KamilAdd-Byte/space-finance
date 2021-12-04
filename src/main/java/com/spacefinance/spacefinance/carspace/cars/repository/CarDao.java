package com.spacefinance.spacefinance.carspace.cars.repository;

import com.spacefinance.spacefinance.carspace.cars.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends MongoRepository<Car,String> {
}

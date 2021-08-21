package com.spacefinance.spacefinance.repository;

import com.spacefinance.spacefinance.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends MongoRepository<Car,String> {
}

package com.spacefinance.spacefinance.repository;

import com.spacefinance.spacefinance.model.CarCare;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCareDao extends MongoRepository<CarCare,String> {
}

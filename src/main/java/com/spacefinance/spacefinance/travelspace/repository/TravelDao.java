package com.spacefinance.spacefinance.travelspace.repository;

import com.spacefinance.spacefinance.travelspace.Travel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface TravelDao extends MongoRepository<Travel,String> {
}

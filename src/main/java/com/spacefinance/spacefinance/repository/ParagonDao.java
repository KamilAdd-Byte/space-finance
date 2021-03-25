package com.spacefinance.spacefinance.repository;

import com.spacefinance.spacefinance.model.Paragon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface ParagonDao extends MongoRepository<Paragon,String> {
}

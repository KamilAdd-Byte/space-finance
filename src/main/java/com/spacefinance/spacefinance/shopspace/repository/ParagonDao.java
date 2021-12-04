package com.spacefinance.spacefinance.shopspace.repository;

import com.spacefinance.spacefinance.shopspace.Paragon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface ParagonDao extends MongoRepository<Paragon,String> {
}

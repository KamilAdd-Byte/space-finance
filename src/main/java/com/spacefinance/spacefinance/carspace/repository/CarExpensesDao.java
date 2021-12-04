package com.spacefinance.spacefinance.carspace.repository;

import com.spacefinance.spacefinance.carspace.CarExpenses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface CarExpensesDao extends MongoRepository<CarExpenses,String> {
}

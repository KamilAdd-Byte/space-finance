package com.spacefinance.spacefinance.repository;

import com.spacefinance.spacefinance.model.Paragon;
import com.spacefinance.spacefinance.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableMongoRepositories
public interface UserDao extends MongoRepository<User,String> {
}

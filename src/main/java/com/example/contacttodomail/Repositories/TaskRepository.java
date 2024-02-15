package com.example.contacttodomail.Repositories;

import com.example.contacttodomail.DTO.Tasks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Tasks,String> {
}

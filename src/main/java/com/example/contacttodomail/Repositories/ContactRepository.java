package com.example.contacttodomail.Repositories;

import com.example.contacttodomail.DTO.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ContactRepository extends MongoRepository<Contact,String> {
}

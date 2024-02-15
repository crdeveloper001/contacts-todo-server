package com.example.contacttodomail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.example.contacttodomail.Repositories"})
public class ContactTodoMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactTodoMailApplication.class, args);
    }

}

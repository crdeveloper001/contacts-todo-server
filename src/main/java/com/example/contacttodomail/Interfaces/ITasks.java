package com.example.contacttodomail.Interfaces;

import com.example.contacttodomail.DTO.Tasks;

import java.util.List;

public interface ITasks {

    List<Tasks> GetAllTask();
    Tasks AddNewTask(Tasks information) throws Exception;
    Tasks UpdateTask(Tasks update);
    String DeleteTask(String id);

}

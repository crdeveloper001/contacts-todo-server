package com.example.contacttodomail.Services;

import com.example.contacttodomail.DTO.Tasks;
import com.example.contacttodomail.Interfaces.ITasks;
import com.example.contacttodomail.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService implements ITasks {

    @Autowired
    private TaskRepository task_repo;
    @Override
    public List<Tasks> GetAllTask() {

        return task_repo.findAll();

    }
    @Override
    public Tasks AddNewTask(Tasks information) throws Exception {
        try{
            if (information.equals(null) || information.get_id().equals("")) {
                information.set_id(UUID.randomUUID().toString());
                task_repo.save(information);
                return information;
            }else{
                throw new Exception("INVALID DATA");
            }
        }catch (Exception error){
            throw new Exception("SOMETHING HAPPEN IN THE SERVER OR CONNECTION TO DB FAILS");
        }
    }
    @Override
    public Tasks UpdateTask(Tasks update) {

        try {
            if (task_repo.existsById(update.get_id())) {
                task_repo.save(update);
                return update;
            } else if (!task_repo.existsById(update.get_id())) {
                return null;
            } else {
                return null;
            }
        } catch (Exception error) {
            throw error;
        }
    }
    @Override
    public String DeleteTask(String id) {
        try {
            if (task_repo.existsById(id)) {
                task_repo.deleteById(id);
                return "task delete";
            } else if (!task_repo.existsById(id)) {
                return "task does not exist";
            } else {
                return "cannot delete task or unexisting";
            }
        } catch (Exception error) {
            return error.getMessage();
        }
    }
}

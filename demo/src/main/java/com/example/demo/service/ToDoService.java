package com.example.demo.service;

import com.example.demo.entity.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> getToDoById(Long toDoId) {
        return toDoRepository.findById(toDoId);
    }

    public ToDo saveOrUpdateToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public void deleteToDoById(Long toDoId) {
        toDoRepository.deleteById(toDoId);
    }

    public List<ToDo> getToDosByUserId(Long userId) {
        return toDoRepository.findByUserId(userId);
    }

    public List<ToDo> getCompletedToDos(boolean completed) {
        return toDoRepository.findByCompleted(completed);
    }
}

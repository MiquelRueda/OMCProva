package com.example.demo.controller;

import com.example.demo.entity.ToDo;
import com.example.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoService.getAllToDos();
    }

    @GetMapping("/{toDoId}")
    public Optional<ToDo> getToDoById(@PathVariable Long toDoId) {
        return toDoService.getToDoById(toDoId);
    }

    @PostMapping
    public ToDo createOrUpdateToDo(@RequestBody ToDo toDo) {
        return toDoService.saveOrUpdateToDo(toDo);
    }

    @PutMapping("/{toDoId}")
    public ToDo updateToDo(@PathVariable Long toDoId, @RequestBody ToDo toDo) {
        toDo.setId(toDoId);
        return toDoService.saveOrUpdateToDo(toDo);
    }

    @DeleteMapping("/{toDoId}")
    public void deleteToDoById(@PathVariable Long toDoId) {
        toDoService.deleteToDoById(toDoId);
    }
}

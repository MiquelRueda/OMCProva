package com.example.demo.mvc.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.service.ToDoService;
import com.example.demo.service.UserService;
import com.example.demo.entity.ToDo;
import com.example.demo.entity.User;

@Controller
@RequestMapping("/todos")
public class ToDoMvcController {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ModelAndView showAllToDos() {
        ModelAndView modelAndView = new ModelAndView("todos");
        modelAndView.addObject("listToDos", toDoService.getAllToDos());
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("todo-new");
        modelAndView.addObject("todo", new ToDo());
        modelAndView.addObject("userList", userService.getAllUsers());
        return modelAndView;
    }

    @PostMapping("/new")
    public String createToDo(@ModelAttribute("todo") ToDo todo, @RequestParam("user.id") Long userId) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID: " + userId));
        todo.setUser(user);
        toDoService.saveOrUpdateToDo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("todo-edit");
        ToDo todo = toDoService.getToDoById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ToDo ID: " + id));
        modelAndView.addObject("todo", todo);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String updateToDo(@PathVariable("id") Long id, @ModelAttribute("todo") ToDo todo) {
        ToDo existingToDo = toDoService.getToDoById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ToDo ID: " + id));
        existingToDo.setTitle(todo.getTitle());
        existingToDo.setCompleted(todo.getCompleted());
        toDoService.saveOrUpdateToDo(existingToDo);
        return "redirect:/todos";
    }

    @PostMapping("/delete/{id}")
    public String deleteToDo(@PathVariable Long id) {
        toDoService.deleteToDoById(id);
        return "redirect:/todos";
    }
}
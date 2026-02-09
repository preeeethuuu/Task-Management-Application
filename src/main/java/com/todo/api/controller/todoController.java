package com.todo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.todo.api.entity.todo;
import com.todo.api.service.todoService;

@RestController
@RequestMapping("/todo")
public class todoController {

    @Autowired
    private todoService service;

    @PostMapping("/add")
    public todo addTodo(@RequestBody todo todo) {
        return service.addTodo(todo);
    }

    @GetMapping
    public List<todo> getAllTodos() {
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public todo getTodo(@PathVariable int id) {
        return service.getTodoById(id);
    }

    @PutMapping("/update/{id}")
    public todo updateTodo(@PathVariable int id, @RequestBody todo todo) {
        return service.updateTodo(id, todo);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        service.deleteTodo(id);
        return "Todo deleted successfully";
    }
}

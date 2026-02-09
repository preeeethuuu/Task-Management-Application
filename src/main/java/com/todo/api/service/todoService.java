package com.todo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.api.entity.todo;
import com.todo.api.repository.todoRepository;

@Service
public class todoService {

    @Autowired
    private todoRepository repo;

    public todo addTodo(todo todo) {
        return repo.save(todo);
    }

    public List<todo> getAllTodos() {
        return repo.findAll();
    }

    public todo getTodoById(int id) {
        return repo.findById(id).orElse(null);
    }

    public todo updateTodo(int id, todo todo) {
        todo existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(todo.getTitle());
            existing.setDescription(todo.getDescription());
            existing.setCompleted(todo.isCompleted());
            return repo.save(existing);
        }
        return null;
    }

    public void deleteTodo(int id) {
        repo.deleteById(id);
    }
}

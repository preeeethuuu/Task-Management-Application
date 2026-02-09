package com.todo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todo.api.entity.todo;

public interface todoRepository extends JpaRepository<todo, Integer> {
}

package com.beginner_level.TodoApp.repository;


import com.beginner_level.TodoApp.entity.Todo;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    List<Todo> findByCompleted(boolean status);

}

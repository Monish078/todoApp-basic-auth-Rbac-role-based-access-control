package com.beginner_level.TodoApp.service;

import com.beginner_level.TodoApp.dto.TodoRequest;
import com.beginner_level.TodoApp.dto.TodoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TodoService {
    TodoResponse createTodo(TodoRequest task);

    Page<TodoResponse> getAllTodos(int pageNo, int size,String sortBy);

    TodoResponse getTodoById(Long id);

    TodoResponse updateTodo(Long id, TodoRequest todoRequest);

    void deleteTodo(Long id);

    List<TodoResponse> getTodoByStatus(boolean status);
}

package com.beginner_level.TodoApp.controller;

import com.beginner_level.TodoApp.dto.TodoRequest;
import com.beginner_level.TodoApp.dto.TodoResponse;
import com.beginner_level.TodoApp.repository.TodoRepository;
import com.beginner_level.TodoApp.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    private final TodoRepository todoRepository;

    @GetMapping("/hello")
    public String getMeassage() {
        return "Hello, this is todo app";
    }

    // create todo api
    @PostMapping
    public ResponseEntity<TodoResponse> createTask(@Valid @RequestBody TodoRequest task)  {
        return ResponseEntity.ok(todoService.createTodo(task));
    }

    @GetMapping("/admin")
    public ResponseEntity<Page<TodoResponse>> getAllTodos(
            @RequestParam(defaultValue = "0") int pageNo,       // Default phela page
            @RequestParam(defaultValue = "2") int size,       // Default ek page par 5 todos load honge
            @RequestParam(defaultValue = "id") String sortBy    // sorting id pe hogi
    )
    {
        Page<TodoResponse> allTodos = todoService.getAllTodos(pageNo, size, sortBy);
        return ResponseEntity.ok(allTodos);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, @RequestBody TodoRequest todo) {
        return ResponseEntity.ok(todoService.updateTodo(id, todo));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Todo deleted successfully");
    }

    // get todo by status
    @GetMapping("/admin/status")
    public ResponseEntity<List<TodoResponse>> getTodoByStatus(@RequestParam boolean status) {
        List<TodoResponse> todoByStatus = todoService.getTodoByStatus(status);
        return ResponseEntity.ok(todoByStatus);
    }


}

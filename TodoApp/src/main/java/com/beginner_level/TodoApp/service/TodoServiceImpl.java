package com.beginner_level.TodoApp.service;

import com.beginner_level.TodoApp.dto.TodoRequest;
import com.beginner_level.TodoApp.dto.TodoResponse;
import com.beginner_level.TodoApp.entity.Todo;
import com.beginner_level.TodoApp.exception.ResourceNotFoundException;
import com.beginner_level.TodoApp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    @Override // create the task todo in db
    public TodoResponse createTodo(TodoRequest task) {
        // first convert the dto to entity
        Todo savedTodo = todoRepository.save(modelMapper.map(task, Todo.class));

        return modelMapper.map(savedTodo, TodoResponse.class);
    }



    @Override
    public Page<TodoResponse> getAllTodos(int pageNo,int size,String sortBy) {


        // 1. Pageable object taiyar karo (Page Number, Size, aur Sorting mila kar)
        Pageable pageable = PageRequest.of(pageNo, size, Sort.by(sortBy).ascending());

        //2. Database se page wise data nikalo aur return kar do
        Page<Todo> allTodo = todoRepository.findAll(pageable);

        // 3.all todo ko Response dto mai convert karo aur return karo
        // 2. Page ke inbuilt .map() se Todo ko TodoResponseDto me convert kiya
        Page<TodoResponse> dtoPage = allTodo.map(todo -> modelMapper.map(todo, TodoResponse.class));

        // 4 return kardo dto wala page
        return dtoPage;

    }

    @Override
    public TodoResponse getTodoById(Long id) {
         Todo todo  = todoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Todo not found with id: " + id));

         return modelMapper.map(todo,TodoResponse.class);
    }

    @Override
    public TodoResponse updateTodo(Long id, TodoRequest todo) {

        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Todo not found with id: " + id));

        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setCompleted(todo.getCompleted());

        // save persist the todo
        Todo save = todoRepository.save(existingTodo);
        return modelMapper.map(save,TodoResponse.class);

    }

    @Override
    public void deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Todo not found with id: " + id));

        todoRepository.delete(todo);
    }

    // todo by status
    @Override
    public List<TodoResponse> getTodoByStatus(boolean status) {
        List<Todo> list = todoRepository.findByCompleted(status);
        List<TodoResponse> listByStatus = list.stream()
                .map((element) -> modelMapper.map(element, TodoResponse.class)).toList();

        return listByStatus;
    }


}

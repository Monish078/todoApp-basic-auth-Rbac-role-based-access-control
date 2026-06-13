package com.beginner_level.TodoApp.dto;

import lombok.Data;

@Data
public class TodoResponse {
    private Long id;

    private String title;

    private String description;

    private Boolean completed;
}

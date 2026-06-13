package com.beginner_level.TodoApp.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class TodoRequest { // request dto

    @NotNull
    private String title;

    private String description;

    private Boolean completed;
}

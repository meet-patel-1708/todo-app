package com.todo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TODORequest {
    @NotBlank(message = "Title must not be null")
    private String title;
    @NotNull(message = "Priority is required")
    private Priority priority;
    private boolean completed;
}

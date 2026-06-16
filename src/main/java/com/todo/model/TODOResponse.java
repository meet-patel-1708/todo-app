package com.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TODOResponse {
    private Long id;
    private String title;
    private boolean completed;
    private Priority priority;
}

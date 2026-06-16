package com.todo.model;

import org.springframework.stereotype.Component;

@Component
public class TODOMapper {
    public TODO toEntity(TODORequest request) {
        return new TODO(request.getTitle(), request.getPriority());
    }

    public void updateEntity(TODO todo, TODORequest request) {
        todo.setName(request.getTitle());
        todo.setPriority(request.getPriority());
        todo.setCompleted(request.isCompleted());
    }

    public TODOResponse toResponse(TODO todo) {
        return new TODOResponse(
                todo.getId(),
                todo.getName(),
                todo.isCompleted(),
                todo.getPriority()
        );
    }
}

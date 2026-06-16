package com.todo.Services;

import com.todo.model.Priority;
import com.todo.model.TODOResponse;

import java.util.List;

public interface FilteredTODOServices {
    List<TODOResponse> getByPriority(Priority priority);
    List<TODOResponse> getByStatus(boolean completed);
}

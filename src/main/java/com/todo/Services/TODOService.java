package com.todo.Services;

import com.todo.model.TODORequest;
import com.todo.model.TODOResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface TODOService {
    List<TODOResponse> getAll();
    TODOResponse getById(Long id);
    TODOResponse create(TODORequest request);
    TODOResponse update(Long id, TODORequest request);
    void delete(Long id);
}

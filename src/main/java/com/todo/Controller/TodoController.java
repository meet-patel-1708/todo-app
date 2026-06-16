package com.todo.Controller;

import com.todo.Services.FilteredTODOServices;
import com.todo.Services.TODOService;
import com.todo.model.Priority;
import com.todo.model.TODORequest;
import com.todo.model.TODOResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TODOService service;
    private final FilteredTODOServices filteredTODOServices;
    public TodoController(TODOService service,FilteredTODOServices filteredTODOServices){
        this.service = service;
        this.filteredTODOServices = filteredTODOServices;
    }
    @GetMapping
    public List<TODOResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TODOResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @PostMapping
    public ResponseEntity<TODOResponse> create(@Valid @RequestBody TODORequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public TODOResponse update(@PathVariable Long id,
                               @Valid @RequestBody TODORequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ── Filters (ISP: FilterableTodoService) ─────────────────────────────

    @GetMapping("/filter/priority/{priority}")
    public List<TODOResponse> byPriority(@PathVariable Priority priority) {
        return filteredTODOServices.getByPriority(priority);
    }

    @GetMapping("/filter/status")
    public List<TODOResponse> byStatus(@RequestParam boolean completed) {
        return filteredTODOServices.getByStatus(completed);
    }
}

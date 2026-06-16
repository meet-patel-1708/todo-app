package com.todo.Services;

import com.todo.ExceptionHandler.TODONotFoundException;
import com.todo.Repository.TODOReqpository;
import com.todo.model.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TODOServicesIMPL implements TODOService,FilteredTODOServices{
    private final TODOReqpository reqpository;
    private final TODOMapper todoMapper;
    public TODOServicesIMPL(TODOReqpository reqpository,TODOMapper mapper){
        this.reqpository = reqpository;
        this.todoMapper = mapper;
    }
    @Override
    public List<TODOResponse> getAll
            (){
        return reqpository.findAll().stream().map(todoMapper::toResponse).toList();
    }
    @Override
    public TODOResponse getById(Long id){
        TODO todo = findOrThrow(id);
        return todoMapper.toResponse(todo);
    }
    private TODO findOrThrow(Long id) {
        return reqpository.findById(id)
                .orElseThrow(() -> new TODONotFoundException(id));
    }
    @Override
    public TODOResponse create(TODORequest request){
        TODO todo = reqpository.save(todoMapper.toEntity(request));
        return todoMapper.toResponse(todo);
    }
    @Override
    public TODOResponse update(Long id, TODORequest request) {
        TODO todo = findOrThrow(id);
        todoMapper.updateEntity(todo, request);
        return todoMapper.toResponse(reqpository.save(todo));
    }
    @Override
    public void delete(Long id) {
        findOrThrow(id);
        reqpository.deleteById(id);
    }
    @Override
    public List<TODOResponse> getByPriority(Priority priority){
        return reqpository.findByPriority(priority).stream().map(todoMapper::toResponse).toList();
    }
    @Override
    public List<TODOResponse> getByStatus(boolean completed){
        return reqpository.findByCompleted(completed).stream().map(todoMapper::toResponse).toList();
    }
}

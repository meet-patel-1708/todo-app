package com.todo.ExceptionHandler;

public class TODONotFoundException extends RuntimeException{
    public TODONotFoundException(Long id){
        super("TODO not found with id:"+id);
    }
}

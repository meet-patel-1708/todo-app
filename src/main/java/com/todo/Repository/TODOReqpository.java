package com.todo.Repository;

import com.todo.model.Priority;
import com.todo.model.TODO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TODOReqpository extends JpaRepository<TODO,Long> {
    List<TODO> findByPriority(Priority priority);
    List<TODO> findByCompleted(boolean completed);
}

package com.todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@Table(name = "todos")
public class TODO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Length(min = 10,max = 15,message = "name length must be between 10 and 15")
    @Column(name = "Name",nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "Completed",nullable = false)
    private boolean completed;

    public TODO(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
        this.completed = false;
    }
}

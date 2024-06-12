package org.example.entity;


import jakarta.persistence.*;

import java.lang.annotation.ElementType;

@Entity
@Table(schema = "public")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer id;
    Boolean isDone = false;
    @ManyToOne
    Users user;

}

package org.example.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(schema = "public")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer id;
    String userName;
    String password;
    String age;
    @OneToMany
    List<Todo> todos = new ArrayList();

}

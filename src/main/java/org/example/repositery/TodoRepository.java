package org.example.repositery;

import org.example.entity.Todo;

import java.util.List;

public class TodoRepository implements BaseRepository<Todo>{
    @Override
    public Todo getOne(Integer id) {
        return null;
    }

    @Override
    public List<Todo> getAll() {
        return List.of();
    }

    @Override
    public Todo save(Todo entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Todo entity) {

    }
}

package org.example.repositery;

import java.util.List;

public interface BaseRepository<T> {

    public T getOne(Integer id) ;
    public List<T> getAll();
    public T save(T entity);
    public void delete(Integer id);
    public void update(T entity);
}

package service;

import java.util.List;

public interface Service<T> {


    T getById(long id);

    List<T> getAll();

    boolean save(T t);

    boolean update(T t);

    boolean delete(long id);
}

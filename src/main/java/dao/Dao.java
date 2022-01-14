package dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T getById(long id) throws SQLException;

    List<T> getAll() throws SQLException;

    boolean save(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean delete(long id) throws SQLException;
}

package dao;

import java.util.List;

public interface DaoInterface<T> {
    List<T> getAll();
    T get(int id);
    void save(T t);
    void update(T t, String[] params);
    void delete(T t);
}

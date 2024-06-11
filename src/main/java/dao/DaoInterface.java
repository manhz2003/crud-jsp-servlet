package dao;

import java.util.List;

public interface DaoInterface<T> {
    List<T> getAll();
    T get(int id);
    void save(T t);
    void update(T t);
    void delete(T t);
    List<T> searchByName(String name);
    List<T> filterByPrice(double minPrice, double maxPrice);
}

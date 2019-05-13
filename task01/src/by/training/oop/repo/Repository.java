package by.training.oop.repo;

import java.util.List;

public interface Repository<T> {
    void add(T item);
    void remove(T item);
    void remove(Specification<T> spec);
    void sort(Specification<T> spec);
    List<T> find(Specification<T> spec);
}

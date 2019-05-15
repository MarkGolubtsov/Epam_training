package by.training.oop.repo;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T item);
    void remove(T item);
    void remove(Specification<T> spec);
    void sort(Comparator<T> comparator);
    List<T> find(Specification<T> spec);
}

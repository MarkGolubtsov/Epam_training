package by.training.oop.repo;

public interface Specification<T> {

    boolean match(T bean);
}

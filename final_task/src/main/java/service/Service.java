package service;

import java.util.List;

public interface Service<T> {

    List<T> findAll();
}

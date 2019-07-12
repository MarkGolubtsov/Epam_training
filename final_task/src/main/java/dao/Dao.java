package dao;

import domain.Entity;

public interface Dao <Type extends Entity> {
    Integer create(Type entity);

    Type read(Integer id);

    void update(Type entity);

    void delete(Integer id);
}

package dao;

import domain.ChoseProduct;

import java.util.List;

public interface ChoseProductDao extends Dao<ChoseProductDao> {

    List<ChoseProduct> readByOrderId(int order_id);
}

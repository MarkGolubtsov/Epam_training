package service;

import domain.ChoseProduct;

public interface ChoseProductService extends Service<ChoseProduct> {
    void save(ChoseProduct choseProduct);

    void findByOrderId(int order_id);

    void deleteByOrderId(int order_id);

    void deleteByProductId(int user_id);
}

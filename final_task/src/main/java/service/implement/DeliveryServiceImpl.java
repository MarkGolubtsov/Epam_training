package service.implement;

import dao.DaoFactory;
import dao.DeliveryDao;
import domain.Delivery;
import exception.DBException;
import service.DeliveryService;

import java.util.List;

public class DeliveryServiceImpl extends ServiceImpl implements DeliveryService {

    public DeliveryServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public void save(Delivery delivery) throws DBException {
        DeliveryDao deliveryDao = daoFactory.createDao(DeliveryDao.class);
        deliveryDao.create(delivery);
    }

    @Override
    public List<Delivery> findAll() throws DBException {
        DeliveryDao deliveryDao = daoFactory.createDao(DeliveryDao.class);
        return deliveryDao.read();
    }

    @Override
    public void update(Delivery delivery) throws DBException {
        DeliveryDao deliveryDao = daoFactory.createDao(DeliveryDao.class);
        deliveryDao.update(delivery);
    }

    @Override
    public void delete(Delivery delivery) throws DBException {
        DeliveryDao deliveryDao = daoFactory.createDao(DeliveryDao.class);
        deliveryDao.delete(delivery);
    }


    @Override
    public List<Delivery> readByCourierId(int order_id) throws DBException {
        DeliveryDao deliveryDao = daoFactory.createDao(DeliveryDao.class);
        return deliveryDao.readByCourierId(order_id);
    }

    @Override
    public List<Delivery> readByUserId(int user_id) throws DBException {
        DeliveryDao deliveryDao = daoFactory.createDao(DeliveryDao.class);
        return  deliveryDao.readByUserId(user_id);
    }
}

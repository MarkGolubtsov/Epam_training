package service.implement;

import dao.DaoFactory;
import dao.DeliveryDao;
import domain.ContainUser;
import domain.Delivery;
import exception.DBException;
import service.DeliveryService;
import service.fill.FillUser;

import java.util.List;

public class DeliveryServiceImpl extends ServiceImpl implements DeliveryService, FillUser {

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
        List<Delivery> result = deliveryDao.read();
        fillList(result);
        return result;
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
        List<Delivery> result= deliveryDao.readByCourierId(order_id);
        fillList(result);
        return result;
    }

    @Override
    public List<Delivery> readByUserId(int user_id) throws DBException {
        DeliveryDao deliveryDao = daoFactory.createDao(DeliveryDao.class);
        List<Delivery> result=deliveryDao.readByUserId(user_id);
        fillList(result);
        return  result;
    }
    private void fillList(List<Delivery> list) throws DBException {
        for (Delivery d:
             list ) {
            fillUser(d,daoFactory);
        }

    }
}

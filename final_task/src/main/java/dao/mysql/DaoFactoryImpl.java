package dao.mysql;

import dao.*;
import dao.pool.ConnectionPool;
import exception.DBException;

import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum DaoFactoryImpl implements DaoFactory {
    INSTANСE;
    private static Map<Class<? extends Dao>, Class<? extends Base>> classes = new ConcurrentHashMap<>();
    static {
        classes.put(AddressDao.class, AddressDaoImpl.class);
        classes.put(ChoseProductDao.class, ChoseProductDaoImpl.class);
        classes.put(DeliveryDao.class, DeliveryDaoImpl.class);
        classes.put(OrderDao.class, OrderDaoImpl.class);
        classes.put(ProductDao.class, ProductDaoImpl.class);
        classes.put(UserDao.class, UserDaoImpl.class);
        classes.put(CartDao.class, CartDaoImpl.class);
        classes.put(OrderedProductDao.class, OrderedProductDaoImpl.class);
    }




    public <Type extends Dao> Type createDao(Class<Type> key) throws DBException {
        Class<? extends Base> value = classes.get(key);
        if(value != null) {
            try {
                Base dao = value.newInstance();
                Connection connection = ConnectionPool.INSTANCE.getConnection();
                dao.setConnection(connection);
                return (Type)dao;
            } catch(InstantiationException | IllegalAccessException e) {
                //logger.error("It is impossible to create data access object", e);
                throw new DBException(e);
            }
        }
        return null;
    }

}

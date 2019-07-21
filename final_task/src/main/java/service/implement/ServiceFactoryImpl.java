package service.implement;

import dao.DaoFactory;
import exception.DBException;
import service.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum  ServiceFactoryImpl implements ServiceFactory {

    INSTANCE;
    private static final Map<Class<? extends Service>, Class<? extends ServiceImpl>> SERVICES = new ConcurrentHashMap<>();
    static {
        SERVICES.put(AddressService.class, AddressServiceImpl.class);
        SERVICES.put(ChoseProductService.class,ChoseProductServiceImpl.class);
        SERVICES.put(UserService.class, UserServiceImpl.class);
        SERVICES.put(DeliveryService.class, DeliveryServiceImpl.class);
        SERVICES.put(OrderService.class, OrderServiceImpl.class);
        SERVICES.put(ProductService.class,ProductServiceImpl.class);
    }
    private  DaoFactory daoFactory ;
    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public <Type extends Service> Type getService(Class<Type> key) throws DBException {

        Class<? extends ServiceImpl> value = SERVICES.get(key);
        if(value != null) {
            try {
                ServiceImpl service = value.newInstance();
                service.SetDaoFactory(daoFactory);
                return (Type) service;
            } catch(InstantiationException | IllegalAccessException e) {
                throw new DBException(e);
            }
        }
        return null;
    }


}

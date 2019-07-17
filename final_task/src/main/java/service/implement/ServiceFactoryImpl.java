package service.implement;

import exception.DBException;
import service.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceFactoryImpl implements ServiceFactory {

    private static final Map<Class<? extends Service>, Class<? extends ServiceImpl>> SERVICES = new ConcurrentHashMap<>();
    static {
        SERVICES.put(AddressService.class, AddressServiceImpl.class);
        SERVICES.put(ChoseProductService.class,ChoseProductServiceImpl.class);
        SERVICES.put(UserService.class, UserServiceImpl.class);
        SERVICES.put(DeliveryService.class, DeliveryServiceImpl.class);
        SERVICES.put(OrderService.class, OrderServiceImpl.class);
        SERVICES.put(ProductService.class,ProductServiceImpl.class);
    }
    @Override
    public <Type extends Service> Type getService(Class<Type> key) throws DBException {

        Class<? extends ServiceImpl> value = SERVICES.get(key);
        if(value != null) {
            try {
                ServiceImpl service = value.newInstance();
                return (Type) service;
            } catch(InstantiationException | IllegalAccessException e) {
                throw new DBException(e);
            }
        }
        return null;
    }
}

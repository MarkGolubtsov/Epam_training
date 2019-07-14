package dao.mysql;

import dao.*;

public enum DaoFactoryImpl implements DaoFactory {
    INSTANСE;

    private final  AddressDaoImpl  addressDao = new AddressDaoImpl();
    private final ChoseProductDaoImpl choseProductDaoproductDao = new ChoseProductDaoImpl();
    private final DeliveryDaoImpl deliveryDao = new DeliveryDaoImpl();
    private  final  OrderDaoImpl orderDao = new OrderDaoImpl();
    private  final  ProductDaoImpl productDao = new ProductDaoImpl();
    private final UserDaoImpl userDao = new UserDaoImpl();

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public ChoseProductDao getChoseProductDaoproductDao() {
        return choseProductDaoproductDao;
    }

    public DeliveryDao getDeliveryDao() {
        return deliveryDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}

package dao;

public interface DaoFactory  {
    AddressDao getAddressDao();
    ChoseProductDao getChoseProductDaoproductDao();
    DeliveryDao getDeliveryDao();
    OrderDao getOrderDao();
    ProductDao getProductDao();
    UserDao getUserDao();
}

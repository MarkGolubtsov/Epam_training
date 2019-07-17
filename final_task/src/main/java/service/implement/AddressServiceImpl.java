package service.implement;

import dao.AddressDao;
import dao.DaoFactory;
import dao.UserDao;
import domain.Address;
import domain.User;
import exception.DBException;
import service.AddressService;
import service.fill.FillUser;

import java.util.List;

public class AddressServiceImpl extends ServiceImpl implements AddressService, FillUser {
   public AddressServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public void save(Address address) throws DBException {
        AddressDao addressDao = daoFactory.createDao(AddressDao.class);
        addressDao.create(address);
    }

    @Override
    public void delete(Address address) throws DBException {
    AddressDao addressDao = daoFactory.createDao(AddressDao.class);
    addressDao.delete(address);
    }

    @Override
    public List<Address> readByStreet(String street) throws DBException {
        AddressDao addressDao = daoFactory.createDao(AddressDao.class);
        List<Address> result = addressDao.readByStreet(street);
        fillListEntity(result);
        return  result;
    }

    @Override
    public List<Address> readByHouse(int house) throws DBException {
        AddressDao addressDao = daoFactory.createDao(AddressDao.class);
        List<Address> result =  addressDao.readByHouse(house);
        return result;
    }

    @Override
    public List<Address> findAll() throws DBException {
        AddressDao addressDao = daoFactory.createDao(AddressDao.class);
        List<Address> result = addressDao.read();
        fillListEntity(result);
        return result;
    }

    @Override
    public void update(Address entity) throws DBException {
        AddressDao addressDao = daoFactory.createDao(AddressDao.class);
        addressDao.update(entity);
    }

    private void fillListEntity(List<Address> addresses) throws DBException {
        for (Address adr:
                addresses) {
            fillEntity(adr);
        }
    }

    private void  fillEntity(Address adr) throws DBException {
        fillUser(adr,daoFactory);
    }
}

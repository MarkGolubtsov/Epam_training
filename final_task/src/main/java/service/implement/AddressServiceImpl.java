package service.implement;

import dao.AddressDao;
import dao.DaoFactory;
import domain.Address;
import domain.User;
import exception.DBException;
import service.AddressService;

import java.util.List;

public class AddressServiceImpl extends ServiceImpl implements AddressService {
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
        return  addressDao.readByStreet(street);
    }

    @Override
    public List<Address> readByHouse(int house) throws DBException {

        AddressDao addressDao = daoFactory.createDao(AddressDao.class);
        return  addressDao.readByHouse(house);
    }

    @Override
    public List<Address> findAll() throws DBException {
        AddressDao addressDao = daoFactory.createDao(AddressDao.class);
        return addressDao.read();
    }

    @Override
    public void update(Address entity) throws DBException {
        AddressDao addressDao = daoFactory.createDao(AddressDao.class);
        addressDao.update(entity);
    }
}

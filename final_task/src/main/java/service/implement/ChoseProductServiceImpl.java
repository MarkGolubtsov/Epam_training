package service.implement;

import dao.ChoseProductDao;
import dao.DaoFactory;
import domain.ChoseProduct;
import exception.DBException;
import service.ChoseProductService;

import java.util.List;

public class ChoseProductServiceImpl extends ServiceImpl implements ChoseProductService {
    public  ChoseProductServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public void save(ChoseProduct choseProduct) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        choseProductDao.create(choseProduct);
    }

    @Override
    public List<ChoseProduct> findByOrderId(int order_id) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        return  choseProductDao.readByOrderId(order_id);
    }

    @Override
    public void delete(ChoseProduct choseProduct) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        choseProductDao.delete(choseProduct);
    }


    @Override
    public List<ChoseProduct> findAll() throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        return choseProductDao.read();
    }

    @Override
    public void update(ChoseProduct entity) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        choseProductDao.update(entity);
    }
}

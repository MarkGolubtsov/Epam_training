package service.implement;

import dao.DaoFactory;

 abstract class ServiceImpl {

    protected DaoFactory daoFactory;

    public void SetDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
 }

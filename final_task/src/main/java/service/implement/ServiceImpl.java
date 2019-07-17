package service.implement;

import dao.DaoFactory;

 abstract class ServiceImpl {

    protected DaoFactory daoFactory;
    ServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}

package com.carrent;
import com.carrent.dao.BaseDAO;
import org.hibernate.HibernateException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import util.SystemLogger;

import java.io.Serializable;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BaseService<T extends BaseEntity> implements IService<T> {

    @Autowired
    private BaseDAO<T> baseDAO;

    @Override
    public void save(T t) throws ServiceException {
        try {
            baseDAO.save(t);
        } catch (HibernateException e) {
            SystemLogger.getInstance().setLogger(getClass(), e);
            throw new ServiceException("ERROR_SAVE_OBJECT");
        }
    }

    @Override
    public T findAll(Class<T> clazz, Serializable id) throws ServiceException {
        T t;
        try {
            t = baseDAO.findAll(clazz, id);
        } catch (HibernateException e) {
            SystemLogger.getInstance().setLogger(getClass(), e);
            throw new ServiceException("ERROR_FIND_OBJECT");
        }
        return t;
    }

    @Override
    public void update(T t) throws ServiceException {
        try {
            baseDAO.update(t);
        } catch (HibernateException e) {
            SystemLogger.getInstance().setLogger(getClass(), e);
            throw new ServiceException("ERROR_UPDATE_OBJECT");
        }
    }

    @Override
    public void delete(T t) throws ServiceException {
        try {
            baseDAO.delete(t);
        } catch (HibernateException e) {
            SystemLogger.getInstance().setLogger(getClass(), e);
            throw new ServiceException("ERROR_DELETE_OBJECT");
        }
    }
}

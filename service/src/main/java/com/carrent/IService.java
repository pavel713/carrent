package com.carrent;

import org.hibernate.service.spi.ServiceException;

import java.io.Serializable;

public interface IService<T> {


        void save(T t) throws ServiceException;


        T findAll(Class<T> clazz, Serializable id) throws ServiceException;


        void update(T t) throws ServiceException;


        void delete(T t) throws ServiceException;

    }



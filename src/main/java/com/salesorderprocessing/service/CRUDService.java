package com.salesorderprocessing.service;

public interface CRUDService<T> {

    Iterable<T> listAll();

    T getById(Integer id);

    T saveOrUpdate(T entity);

    void delete(Integer id);

}

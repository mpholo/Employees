package com.mpholo.learing.employees.services;

public interface CrudService<T,ID> {

    T findById(ID id);
    void deleteById(ID id);
    void delete(T object);
    void save(T object);



}

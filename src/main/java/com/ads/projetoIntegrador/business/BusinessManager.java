/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.business;

import com.ads.projetoIntegrador.dao.IAbstractDAO;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Class for generic business.
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public abstract class BusinessManager<T extends Serializable, IdType extends Serializable>
        implements IBusinessManager<T, IdType> {

    protected IAbstractDAO dao;
    
    @Override
    public void validate(T t) throws IllegalArgumentException {
        if (t == null) {
            throw new IllegalArgumentException("Null Object for parameter");
        }
    }

    @Override
    public T find(IdType id) {
        return (T) getDAO().find(id);
    }

    @Override
    public List<T> find() {
        return getDAO().find();
    }

    @Override
    public List<T> find(String namedQuery, Map<String, Object> params) {
        return getDAO().find(namedQuery, params);
    }
    
    @Override
    public void save(T t) {
        validate(t);
        getDAO().save(t);
    }

    @Override
    public void update(T t) {
        validate(t);
        getDAO().update(t);
    }

    @Override
    public void delete(T t) {
        getDAO().delete(t);
    }

}

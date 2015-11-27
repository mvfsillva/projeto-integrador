/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.business;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.ads.projetoIntegrador.repository.IAbstractRepository;

/**
 * Class for generic business.
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public abstract class BusinessManager<T extends Serializable, IdType extends Serializable>
        implements IBusinessManager<T, IdType> {

    protected IAbstractRepository<T, IdType> repository;
    
    @Override
    public void validate(T t) throws IllegalArgumentException {
        if (t == null) {
            throw new IllegalArgumentException("Null Object for parameter");
        }
    }

    @Override
    public IAbstractRepository<T, IdType> getRepository() {
    	return this.repository;
    }
    
    @Override
    public void setSession(Session session) {
    	repository.setSession(session);
    }
    
    @Override
    public T find(IdType id) {
        return (T) getRepository().find(id);
    }

    @Override
    public List<T> find() {
        return getRepository().find();
    }

    @Override
    public List<T> find(String namedQuery, Map<String, Object> params) {
        return getRepository().find(namedQuery, params);
    }
    
    @Override
    public void save(T t) {
        validate(t);
        getRepository().save(t);
    }

    @Override
    public void update(T t) {
        validate(t);
        getRepository().update(t);
    }

    @Override
    public void delete(T t) {
        getRepository().delete(t);
    }
    
    @Override
    public void delete(List<T> tList) {
    	getRepository().delete(tList);    	
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.facade;

import com.ads.projetoIntegrador.business.IBusinessManager;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public abstract class FacadeManager<T extends Serializable, IdType extends Serializable> 
        implements IFacadeManager<T, IdType> {

    protected IBusinessManager bo;
    
    @Override
    public T find(IdType id) {
        return (T) getBusinessManager().find(id);
    }

    @Override
    public List<T> find() {
        return getBusinessManager().find();
    }

    @Override
    public void save(T t) {
        getBusinessManager().save(t);
    }

    @Override
    public void update(T t) {
        getBusinessManager().update(t);
    }

    @Override
    public void delete(T t) {
        getBusinessManager().delete(t);
    }

}

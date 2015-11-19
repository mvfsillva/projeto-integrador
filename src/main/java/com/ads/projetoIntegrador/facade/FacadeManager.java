/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.facade;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public abstract class FacadeManager<T extends Serializable, IdType extends Serializable> implements IFacadeManager<T, IdType> {


    @Override
    public T find(IdType id) {
        return (T) getBusinessManager().find(id);
    }

    @Override
    public List<T> find() {
        return getBusinessManager().find();
    }

    @Override
    public int save(T t) {
        return getBusinessManager().save(t);
    }

    @Override
    public int update(T t) {
        return getBusinessManager().update(t);
    }

    @Override
    public int delete(T t) {
        return getBusinessManager().delete(t);
    }

}

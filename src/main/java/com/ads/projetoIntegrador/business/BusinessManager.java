/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.business;

import com.ads.projetoIntegrador.dto.AbstractDTO;
import java.io.Serializable;
import java.util.List;

/**
 * Class for generic business.
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public abstract class BusinessManager<T extends AbstractDTO, IdType extends Serializable>
        implements IBusinessManager<T, IdType> {

    @Override
    public void doValidate(T t) throws IllegalArgumentException {
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
    public int save(T t) {
        doValidate(t);
        getDAO().save(t);
        return 0;
    }

    @Override
    public int update(T t) {
        doValidate(t);
        getDAO().update(t);
        return 0;
    }

    @Override
    public int delete(T t) {
        getDAO().delete(t);
        return 0;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.facade;

import com.ads.projetoIntegrador.business.BusinessManager;
import com.ads.projetoIntegrador.business.IBusinessManager;
import com.ads.projetoIntegrador.dto.AbstractDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public class FacadeManager<T extends AbstractDTO, IdType extends Serializable> implements IFacadeManager<T, IdType> {

    private Class<T> classOfEntity;

    public FacadeManager(Class<T> classOfEntity) {
            this.classOfEntity = classOfEntity;
    }
	
    @Override
    public IBusinessManager<T, IdType> getBusinessManager() {
        return new BusinessManager<>(classOfEntity);
    }

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

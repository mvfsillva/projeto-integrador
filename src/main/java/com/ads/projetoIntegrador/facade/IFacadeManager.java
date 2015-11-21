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
public interface IFacadeManager<T extends Serializable, IdType extends Serializable> {

    public IBusinessManager<T, IdType> getBusinessManager();

    public abstract T find(IdType id);

    public abstract List<T> find();

    public abstract void save(T t);

    public abstract void update(T t);

    public abstract void delete(T t);

}

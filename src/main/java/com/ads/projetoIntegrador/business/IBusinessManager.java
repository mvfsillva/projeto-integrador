/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.business;

import com.ads.projetoIntegrador.dao.IAbstractDAO;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public interface IBusinessManager<T, IdType extends Serializable> {

    public void doValidate(T t) throws IllegalArgumentException;

    public IAbstractDAO getDAO();

    public T find(IdType id);

    public List<T> find();

    public int save(T t);

    public int update(T t);

    public int delete(T t);
}

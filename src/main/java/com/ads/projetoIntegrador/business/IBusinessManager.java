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

import com.ads.projetoIntegrador.repository.IRepository;


/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public interface IBusinessManager<T extends Serializable, IdType extends Serializable> {

    public void validate(T t) throws IllegalArgumentException;

    public IRepository<T, IdType> getRepository();

    public void setSession(Session session);
    
    public T find(IdType id);

    public List<T> find();

    public List<T> find(String namedQuery, Map<String, Object> params);
    
    public int save(T t);
    
    public void save(List<T> t);

    public void update(T t);

    public void delete(T t);
    
    public void delete(List<T> tList);
}

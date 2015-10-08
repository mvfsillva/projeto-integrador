package com.ads.projetoIntegrador.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import javax.ws.rs.core.GenericEntity;

/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public class AbstractDAO<T extends GenericEntity, IdType extends Serializable> implements 
		IAbstractDAO<T, IdType> {

    protected Session session;
    
    protected Class<T> classOfEntity;    
    
    public AbstractDAO(Session session, Class<T>classOfEntity) {
        this.session = session;
        this.classOfEntity = classOfEntity;
    }

    public Session getSession() {
        return session;
    }

    @Override
    public int save(T t) {
        getSession().beginTransaction();
        getSession().save(t);
        getSession().flush();
        getSession().getTransaction().commit();
        return 0;
    }

    @Override
    public int update(T t) {
        getSession().beginTransaction();
        getSession().update(t);
        getSession().flush();
        getSession().getTransaction().commit();
        return 0;
    }

    @Override
    public int delete(T t) {
        getSession().beginTransaction();
        getSession().delete(t);
        getSession().flush();
        getSession().getTransaction().commit();
        return 0;
    }

    @SuppressWarnings("unchecked")
	@Override
    public T find(IdType id) {
        getSession().beginTransaction();
        T entity = (T) getSession().get(classOfEntity, id);
        getSession().flush();        
        return entity;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<T> find() {
        getSession().beginTransaction();
        List<T> list = (List<T>) getSession().createQuery("from " + classOfEntity.getName()).list();
        getSession().flush();
        return list;
    }

}

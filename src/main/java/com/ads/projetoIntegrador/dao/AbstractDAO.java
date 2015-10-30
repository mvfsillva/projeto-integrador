package com.ads.projetoIntegrador.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.ads.projetoIntegrador.dto.AbstractDTO;
import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public class AbstractDAO<T extends AbstractDTO, IdType extends Serializable> 
    extends HibernateDaoSupport implements IAbstractDAO<T, IdType> {

    protected Class<T> classOfEntity;    
    
    public AbstractDAO(Class<T>classOfEntity) {
        this.classOfEntity = classOfEntity;
    }
    
    @Autowired
    public void setupSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
    
    @Override
    public int save(T t) {
        getHibernateTemplate().save(t);
        return 0;
    }

    @Override
    public int update(T t) {
        getHibernateTemplate().update(t);
        return 0;
    }

    @Override
    public int delete(T t) {
       getHibernateTemplate().delete(t);
        return 0;
    }

    @Override
    public T find(IdType id) {
        String className = classOfEntity.getName();
        List<T> result = getHibernateTemplate().find("from " + className + " where id_" + className + " = ?", id);
	return (T) result.get(0);
    }

    @Override
    public List<T> find() {
        List<T> result = getHibernateTemplate().find("from " + classOfEntity.getName());
	return result;
    }

}

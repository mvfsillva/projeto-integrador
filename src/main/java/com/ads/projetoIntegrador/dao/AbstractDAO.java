package com.ads.projetoIntegrador.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ads.projetoIntegrador.dto.AbstractDTO;
import com.ads.projetoIntegrador.utils.HibernateUtils;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public class AbstractDAO<T extends AbstractDTO, IdType extends Serializable> implements IAbstractDAO<T, IdType> {

    protected Class<T> classOfEntity;

    public AbstractDAO(Class<T> classOfEntity) {
        this.classOfEntity = classOfEntity;
    }

    @Override
    public Session getSession() {
        return HibernateUtils.getSession();
    }

    @Override
    public void save(T t) {
        getSession().beginTransaction();
        getSession().save(t);
        if (!getSession().getTransaction().wasCommitted())
            getSession().getTransaction().commit();
        getSession().clear();
    }

    @Override
    public void update(T t) {
        getSession().beginTransaction();
        getSession().update(t);
        if (!getSession().getTransaction().wasCommitted())
            getSession().getTransaction().commit();
        getSession().clear();
    }

    @Override
    public void delete(T t) {
        getSession().beginTransaction();
        getSession().delete(t);
        if (!getSession().getTransaction().wasCommitted())
            getSession().getTransaction().commit();
        getSession().clear();
    }

    @Override
    public T find(IdType id) {
        String className = classOfEntity.getName();
        Query query = getSession().createQuery("from " + className + " where id_" + className.replace("DTO", "") + " = :id");
        query.setProperties(id);
        return (T) query.uniqueResult();
    }

    @Override
    public List<T> find() {
        Query query = getSession().createQuery("from " + classOfEntity.getName());
        return (List<T>) query.list();
    }

}

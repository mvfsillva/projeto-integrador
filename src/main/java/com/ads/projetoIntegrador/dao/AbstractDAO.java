package com.ads.projetoIntegrador.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ads.projetoIntegrador.utils.HibernateUtils;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public class AbstractDAO<T extends Serializable, IdType extends Serializable> implements IAbstractDAO<T, IdType> {

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
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.persist(t);
        tx.commit();
        s.flush();
        s.close();
    }

    @Override
    public void update(T t) {
       Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.update(t);
        tx.commit();
        s.flush();
        s.close();
    }

    @Override
    public void delete(T t) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(t);
        tx.commit();
        s.flush();
        s.close();
    }

    @Override
    public T find(IdType id) {
        Session s = getSession();
        String tn = getTableName();
        Query query = s.createQuery("from " + tn + " where " + getIdFieldName() + " = :id");
        Map<String, IdType> m = new HashMap<>();
        m.put("id", id);
        query.setProperties(m);
        return (T) query.uniqueResult();
    }

    @Override
    public List<T> find() {
        Session s = getSession();
        String tn = getTableName();
        Query query = s.createQuery("from ".concat(tn));
        return (List<T>) query.list();
    }
    
    protected String getTableName() {
        return classOfEntity.getName();
    }

    protected String getIdFieldName() {
        Annotation[] ann = classOfEntity.getAnnotations();
        int i;
        for(i = 0; i < ann.length; i++) {
            if(ann[i].annotationType().equals(Table.class)) {
                break;
            }
        }
        if(i == ann.length) throw new IllegalArgumentException();
        return "id_".concat(((Table) ann[i]).name());
    }
}

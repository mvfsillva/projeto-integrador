package org.doando.repository;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public abstract class AbstractRepository<T extends Serializable, IdType extends Serializable>
        implements IRepository<T, IdType> {

    protected Class<T> classOfEntity;
    private Session session;

    public AbstractRepository(Class<T> classOfEntity) {
        this.classOfEntity = classOfEntity;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Session getSession() {
        return this.session;
    }

    @Override
    public int save(T t) {
        Session s = getSession();
        return (int) s.save(t);
    }

    @Override
    public void save(List<T> tList) {
        for (T t : tList) {
            this.save(t);
        }
    }

    @Override
    public void update(T t) {
        Session s = getSession();
        s.update(t);
    }

    @Override
    public void delete(T t) {
        Session s = getSession();
        s.delete(t);
    }

    @Override
    public void delete(List<T> tList) {
        for (T t : tList) {
            this.delete(t);
        }
    }

    @Override
    public List<T> find(String namedQuery, Map<String, Object> params) {
        Session s = getSession();
        Query query = s.getNamedQuery(namedQuery);
        query.setProperties(params);
        return query.list();
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
        Query query = s.createQuery("select a from " + tn + " a");
        return query.list();
    }

    protected String getTableName() {
        return classOfEntity.getName();
    }

    protected String getIdFieldName() {
        Annotation[] ann = classOfEntity.getAnnotations();
        int i;
        for (i = 0; i < ann.length; i++) {
            if (ann[i].annotationType().equals(Table.class)) {
                break;
            }
        }
        if (i == ann.length) {
            throw new IllegalArgumentException();
        }
        return "id_".concat(((Table) ann[i]).name());
    }
}

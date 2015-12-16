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
 * Generalize the database data access into a single class.
 * It can be extended to provide a full data by another classes.
 * Uses Hibernate to simplify the data access calls.
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

    /**
     * Save an entity into the database.
     */
    @Override
    public int save(T t) {
        Session s = getSession();
        return (int) s.save(t);
    }

    /**
     * Save a list of entities into the database.
     */
    @Override
    public void save(List<T> tList) {
        for (T t : tList) {
            this.save(t);
        }
    }

    /**
     * Update an entity into the database.
     */
    @Override
    public void update(T t) {
        Session s = getSession();
        s.update(t);
    }

    /**
     * Delete an entity from database.
     */
    @Override
    public void delete(T t) {
        Session s = getSession();
        s.delete(t);
    }

    /**
     * Delete a list of entities from database.
     */
    @Override
    public void delete(List<T> tList) {
        for (T t : tList) {
            this.delete(t);
        }
    }

    /**
     * Get a list of entity from database by named query.
     */
    @Override
    public List<T> find(String namedQuery, Map<String, Object> params) {
        Session s = getSession();
        Query query = s.getNamedQuery(namedQuery);
        query.setProperties(params);
        return query.list();
    }

    /**
     * Gets a single entity from database by id.
     */
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

    /**
     * Selects all entities from a database's table .
     */
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
    
//    public List<T> find(T t, int o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//    	return null;
//    }
//    
//    private Map<String, Object> getFieldValuesAsQueryParameters(T t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//    	Map<String, Object> out = new HashMap<>();
//    	Method[] methods = classOfEntity.getMethods();
//    	for (int i = 0; i < methods.length; i++) {
//    		if(methods[i].getName().contains("get")) {
//    			Object methodReturn = methods[i].invoke(t);
//    			if(methodReturn instanceof String) {
//    				String temp = (String) methodReturn;
//    				out.put(key, value)
//    			}
//    		}
//		}
//    	return null;
//    }
//    
//    private String getFieldNameByGetMethod(Method m) {
//    	String name = m.getName();
//    	name = name.substring(name.indexOf("get"));
//    	name.
//    }
}

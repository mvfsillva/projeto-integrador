package org.doando.business;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.doando.repository.IRepository;
import org.hibernate.Session;


/**
 * Generic business class that calls the instantiated repository 
 * at subclasses constructor.
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public abstract class AbstractBusiness<T extends Serializable, IdType extends Serializable>
        implements IBusinessManager<T, IdType> {

    protected IRepository<T, IdType> repository;
    
    /**
     * Provides the generic validation that can be overwritten by subclasses.  
     */
    @Override
    public void validate(T t) throws IllegalArgumentException {
        if (t == null) {
            throw new IllegalArgumentException("Null Object for parameter");
        }
    }

    @Override
    public IRepository<T, IdType> getRepository() {
    	return this.repository;
    }
    
    @Override
    public void setSession(Session session) {
    	repository.setSession(session);
    }
    
    /**
     * Gets a single entity from database by id.
     */
    @Override
    public T find(IdType id) {
        return (T) getRepository().find(id);
    }

    /**
     * Selects all entities from a database's table .
     */
    @Override
    public List<T> find() {
        return getRepository().find();
    }
    
    /**
     * Get a list of entity from database by named query.
     */
    @Override
    public List<T> find(String namedQuery, Map<String, Object> params) {
        return getRepository().find(namedQuery, params);
    }
    
    /**
     * Save an entity into the database calling the validations method.
     */
    @Override
    public int save(T t) {
        validate(t);
        return getRepository().save(t);
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
        validate(t);
        getRepository().update(t);
    }

    /**
     * Delete an entity from database.
     */
    @Override
    public void delete(T t) {
        getRepository().delete(t);
    }
    
    /**
     * Delete a list of entities from database.
     */
    @Override
    public void delete(List<T> tList) {
    	getRepository().delete(tList);    	
    }

}

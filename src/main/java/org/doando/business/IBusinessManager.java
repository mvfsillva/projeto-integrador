package org.doando.business;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.doando.repository.IRepository;
import org.hibernate.Session;


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

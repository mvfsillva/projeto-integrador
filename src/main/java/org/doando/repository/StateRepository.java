package org.doando.repository;

import java.util.List;

import org.doando.entity.StateEntity;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yago Ferreira
 */
public class StateRepository extends AbstractRepository<StateEntity, Integer> {

    public StateRepository() {
        super(StateEntity.class);
    }
    
    @Override
    public List<StateEntity> find() {
    	Session s = getSession();
        String tn = getTableName();
        Query query = s.createQuery("select a from " + tn + " a order by a.description");
        return query.list();
    }
    
}

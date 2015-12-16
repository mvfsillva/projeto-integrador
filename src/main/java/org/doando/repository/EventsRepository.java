package org.doando.repository;

import java.util.HashMap;
import java.util.Map;
import org.doando.entity.EventsEntity;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author arthur.hage
 */
public class EventsRepository extends AbstractRepository<EventsEntity, Integer>{
    
    public EventsRepository() {
        super(EventsEntity.class);
    }
    
    public EventsEntity find(String name) {
        Session s = getSession();
        String tn = getTableName();
        Query query = s.createQuery("from " + tn + " where name = :name");
        Map<String, String> m = new HashMap<>();
        m.put("name", name);
        query.setProperties(m);
        return (EventsEntity) query.uniqueResult();
    }
}

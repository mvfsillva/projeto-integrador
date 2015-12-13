package org.doando.repository;

import java.util.HashMap;
import java.util.Map;
import org.doando.entity.OngEntity;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author arthur
 */
public class OngRepository extends AbstractRepository<OngEntity, Integer>{

    public OngRepository() {
        super(OngEntity.class);
    }
    
    public OngEntity find(String name) {
        Session s = getSession();
        String tn = getTableName();
        Query query = s.createQuery("from " + tn + " where name = :name");
        Map<String, String> m = new HashMap<>();
        m.put("name", name);
        query.setProperties(m);
        return (OngEntity) query.uniqueResult();
    }
}

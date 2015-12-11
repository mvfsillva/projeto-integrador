package org.doando.repository;

import java.util.HashMap;
import java.util.Map;
import org.doando.entity.VoluntaryEntity;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author arthur
 */
public class VoluntaryRepository extends AbstractRepository<VoluntaryEntity, Integer>{
    
    public VoluntaryRepository (){
        super(VoluntaryEntity.class);
    }
    
     public VoluntaryEntity find(String name) {
        Session s = getSession();
        String tn = getTableName();
        Query query = s.createQuery("from " + tn + " where name = :name");
        Map<String, String> m = new HashMap<>();
        m.put("name", name);
        query.setProperties(m);
        return (VoluntaryEntity) query.uniqueResult();
    }
    
}

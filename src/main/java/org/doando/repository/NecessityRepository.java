package org.doando.repository;

import java.util.HashMap;
import java.util.Map;
import org.doando.entity.NecessityEntity;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author arthur.hage
 */
public class NecessityRepository extends AbstractRepository<NecessityEntity, Integer>{

    public NecessityRepository() {
        super(NecessityEntity.class);
    }
    
    public NecessityEntity find(String ongName) {
        Session s = getSession();
        String tn = getTableName();
        Query query = s.createQuery("from " + tn + " where ongName = :ongName");
        Map<String, String> m = new HashMap<>();
        m.put("ongName", ongName);
        query.setProperties(m);
        return (NecessityEntity) query.uniqueResult();
    }
    
}

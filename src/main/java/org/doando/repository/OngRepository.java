package org.doando.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.doando.entity.OngEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author arthur
 */
public class OngRepository extends AbstractRepository<OngEntity, Integer>{

    public OngRepository() {
        super(OngEntity.class);
    }
    
    public OngEntity find(String email, String cnpj) {
        Session s = getSession();
        String tn = getTableName();
        Query query = s.createQuery("from " + tn + " where email = :email and cnpj = :cnpj");
        Map<String, String> m = new HashMap<>();
        m.put("email", email);
        m.put("cnpj", cnpj);
        query.setProperties(m);
        return (OngEntity) query.uniqueResult();
    }
    
    public List<OngEntity> search (Map<String, Object> params){
        Session s = getSession();
        Iterator<String> keys = params.keySet().iterator();
        Criteria criteria = s.createCriteria(OngEntity.class);
        while(keys.hasNext()){
            final String key = keys.next();
            final Object obj = params.get(key);
            criteria.add(Restrictions.ilike(key, "%" + obj.toString() + "%"));
        }
        List results = criteria.list();
        return results;
    }
}

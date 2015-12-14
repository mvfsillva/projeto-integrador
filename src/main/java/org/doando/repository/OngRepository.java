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
}

package org.doando.repository;

import java.util.HashMap;
import java.util.Map;

import org.doando.entity.PersonEntity;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yago Ferreira
 */
public class PersonRepository extends AbstractRepository<PersonEntity, Integer> {

    public PersonRepository() {
        super(PersonEntity.class);
    }

    public PersonEntity find(String name) {
        Session s = getSession();
        String tn = getTableName();
        Query query = s.createQuery("from " + tn + " where name = :name");
        Map<String, String> m = new HashMap<>();
        m.put("name", name);
        query.setProperties(m);
        return (PersonEntity) query.uniqueResult();
    }
    
}

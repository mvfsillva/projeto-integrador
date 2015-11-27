/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.repository;

import com.ads.projetoIntegrador.entity.PersonEntity;
import com.ads.projetoIntegrador.repository.AbstractRepository;

import java.util.HashMap;
import java.util.Map;
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

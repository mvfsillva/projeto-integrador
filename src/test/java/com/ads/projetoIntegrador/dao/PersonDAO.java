/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dao;

import com.ads.projetoIntegrador.dao.AbstractDAO;
import com.ads.projetoIntegrador.dto.PersonDTO;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Yago Ferreira
 */
public class PersonDAO extends AbstractDAO<PersonDTO, Integer> {

    public PersonDAO() {
        super(PersonDTO.class);
    }

    public PersonDTO find(String name) {
        Session s = getSession();
        String tn = getTableName();
        Query query = s.createQuery("from " + tn + " where name = :name");
        Map<String, String> m = new HashMap<>();
        m.put("name", name);
        query.setProperties(m);
        return (PersonDTO) query.uniqueResult();
    }
    
}

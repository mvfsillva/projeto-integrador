/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.business;

import com.ads.projetoIntegrador.dao.IAbstractDAO;
import com.ads.projetoIntegrador.dao.PersonDAO;
import com.ads.projetoIntegrador.dto.PersonDTO;

/**
 *
 * @author yago
 */
public class PersonBusiness extends BusinessManager<PersonDTO, Integer>{

    @Override
    public IAbstractDAO<PersonDTO, Integer> getDAO() {
        if(dao == null) {
            dao = new PersonDAO();
        }
        return dao;
    }
    
    @Override
    public void validate(PersonDTO t) {
        super.validate(t);
        if(t.getName().isEmpty()) {
            throw new IllegalArgumentException("the name is empty");
        }
    }
    
    public PersonDTO find(String name) {
        return ((PersonDAO) getDAO()).find(name);
    }
    
}

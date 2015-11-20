package com.ads.projetoIntegrador.dao;


import com.ads.projetoIntegrador.dto.PersonDTO;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yago Ferreira
 */
public class DAOTest {

    PersonDAO dao;
    PersonDTO person;
    
    @Before
    public void setUp(){
        dao = new PersonDAO();
        person = new PersonDTO();
    }
        
    @Test
    public void when_insertingAPerson() {
        String name = "TestName";
        person.setName(name);
        dao.save(person);
        assertTrue(dao.find(name).getName().equals(name));
    }
}

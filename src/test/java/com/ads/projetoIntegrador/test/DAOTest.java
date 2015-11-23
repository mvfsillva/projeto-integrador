package com.ads.projetoIntegrador.test;

import com.ads.projetoIntegrador.dao.PersonDAO;
import com.ads.projetoIntegrador.dto.PersonDTO;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yago Ferreira
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DAOTest {

    private PersonDAO dao;
    private PersonDTO person;
    private String name;
    private String newName;

    @Before
    public void setUp() {
        dao = new PersonDAO();
        person = new PersonDTO();
        name = "TestName";
        newName = "newName";
    }

    @Test
    public void when_1_insertingAPerson() {
        person.setName(name);
        dao.save(person);
        assertTrue(dao.find(name).getName().equals(name));
    }

    @Test
    public void when_2_updatingAPerson() {
        PersonDTO p = dao.find(name);
        p.setName(newName);
        dao.update(p);
        assertTrue(dao.find(newName).getName().equals(newName));
    }
    
    @Test
    public void when_3_deletingAPerson() {
        PersonDTO p = dao.find(newName);
        dao.delete(p);
        List<PersonDTO> result = dao.find();
        assertTrue(result.isEmpty());
    }
    
    
}

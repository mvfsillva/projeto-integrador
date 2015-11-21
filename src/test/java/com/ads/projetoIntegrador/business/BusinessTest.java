/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.business;

import com.ads.projetoIntegrador.dto.PersonDTO;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author yago
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BusinessTest {
    
    private PersonBusiness bo;
    private PersonDTO person;
    private String name;
    private String newName;

    @Before
    public void setUp() {
        bo = new PersonBusiness();
        person = new PersonDTO();
        name = "TestName";
        newName = "newName";
    }

    @Test
    public void when_1_insertingAPerson() {
        person.setName(name);
        bo.save(person);
        assertTrue(bo.find(name).getName().equals(name));
    }

    @Test
    public void when_2_updatingAPerson() {
        PersonDTO p = bo.find(name);
        p.setName(newName);
        bo.update(p);
        assertTrue(bo.find(newName).getName().equals(newName));
    }
    
    @Test
    public void when_3_deletingAPerson() {
        PersonDTO p = bo.find(newName);
        bo.delete(p);
        List<PersonDTO> result = bo.find();
        assertTrue(result.isEmpty());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void when_4_tryingToSaveANullEntity() {
        bo.save(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void when_5_tryingToSaveAEntityWithEmptyName() {
        PersonDTO p = new PersonDTO();
        p.setName("");
        bo.save(p);
    }
}

package org.doando.test;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.doando.business.PersonBusiness;
import org.doando.entity.PersonEntity;
import org.doando.utils.HibernateUtils;
import org.hibernate.Session;
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
    private PersonEntity person;
    private String name;
    private String newName;
    private Session session;

    @Before
    public void setUp() {
        bo = new PersonBusiness();
        person = new PersonEntity();
        name = "TestName";
        newName = "newName";
    }
    
    private void initialize() {
        session = HibernateUtils.getSession();
        session.beginTransaction();    	
        bo.setSession(session);
    }
    
    private void commit() {
    	session.getTransaction().commit();
    }
    
    private void cleanUp() {
    	session.flush();
    	session.close();
    }
    
    @Test
    public void when_1_insertingAPerson() {
        person.setName(name);
        initialize();
        bo.save(person);
        commit();
        assertTrue(bo.find(name).getName().equals(name));
        cleanUp();
    }

    @Test
    public void when_2_updatingAPerson() {
        initialize();
        PersonEntity p = bo.find(name);
        p.setName(newName);
        bo.update(p);
        commit();
        assertTrue(bo.find(newName).getName().equals(newName));
        cleanUp();
    }
    
    @Test
    public void when_3_deletingAPerson() {
        initialize();
        PersonEntity p = bo.find(newName);
        bo.delete(p);
        commit();
        List<PersonEntity> result = bo.find();
        assertTrue(result.isEmpty());
        cleanUp();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void when_4_tryingToSaveANullEntity() {
    	PersonEntity p = null;
        bo.save(p);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void when_5_tryingToSaveAEntityWithEmptyName() {
        PersonEntity p = new PersonEntity();
        p.setName("");
        bo.save(p);
    }
}

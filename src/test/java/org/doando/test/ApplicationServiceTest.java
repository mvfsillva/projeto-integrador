package org.doando.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.doando.appclicationService.PersonApplicationService;
import org.doando.entity.PersonEntity;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApplicationServiceTest {


    private PersonApplicationService appService;
    private PersonEntity person;
    private String name;
    private String newName;

    @Before
    public void setUp() {
        appService = new PersonApplicationService();
        person = new PersonEntity();
        name = "TestName";
        newName = "newName";
    }
    
    
    @Test
    public void when_1_insertingAPerson() {
        person.setName(name);
        appService.save(person);
        assertTrue(appService.find(name).getName().equals(name));
    }

    @Test
    public void when_2_updatingAPerson() {
        PersonEntity p = appService.find(name);
        p.setName(newName);
        appService.update(p);
        assertTrue(appService.find(newName).getName().equals(newName));
    }
    
    @Test
    public void when_3_deletingAPerson() {
        PersonEntity p = appService.find(newName);
        appService.delete(p);
        List<PersonEntity> result = appService.find();
        assertTrue(result.isEmpty());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void when_4_tryingToSaveANullEntity() {
    	PersonEntity pe = null;
        appService.save(pe);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void when_5_tryingToSaveAEntityWithEmptyName() {
        PersonEntity p = new PersonEntity();
        p.setName("");
        appService.save(p);
    }
}

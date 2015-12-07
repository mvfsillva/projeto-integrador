package org.doando.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.doando.appService.StateAppService;
import org.doando.entity.StateEntity;
import org.junit.Before;
import org.junit.Test;

public class StateRepositoryTest {

	private StateAppService appService;

    @Before
    public void setUp() {
        appService = new StateAppService();
    }
    
    @Test
    public void when_listingAllStates() {
    	List<StateEntity> result = appService.find(); 
        assertTrue(result.isEmpty());
    }
    
}

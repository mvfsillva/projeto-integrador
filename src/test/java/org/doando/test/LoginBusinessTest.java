package org.doando.test;

import static org.junit.Assert.assertTrue;

import org.doando.business.UserBusiness;
import org.doando.entity.UserEntity;
import org.doando.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author yago
 */
public class LoginBusinessTest {
    
    private UserBusiness bo;
    private UserEntity user;
    private String username;
    private String password;
    private Session session;

    @Before
    public void setUp() {
        bo = new UserBusiness();
        user = new UserEntity();
        username = "test";
        password = "123456";
        user.setUsername(username);
        user.setPassword(password);
        initialize();
        bo.save(user);
        commit();
        cleanUp();
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
    public void when_testingLoginWithCorrectData() throws Exception {
    	initialize();
        assertTrue(bo.tryUserLogin(username, password) != null);
        cleanUp();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void when_testingLoginWithWrongData() throws Exception {
    	initialize();
        bo.tryUserLogin(username, password + "123");
        cleanUp();
    }
    
    @After
    public void tearDown() throws Exception {
    	initialize();
        UserEntity u = bo.tryUserLogin(username, password);
        bo.delete(u);
        commit();
        cleanUp();
    }
    
}

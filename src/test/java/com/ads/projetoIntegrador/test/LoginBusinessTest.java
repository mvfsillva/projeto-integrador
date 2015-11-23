/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.test;

import com.ads.projetoIntegrador.business.UserBusiness;
import com.ads.projetoIntegrador.dto.UserDTO;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author yago
 */
public class LoginBusinessTest {
    
    private UserBusiness bo;
    private UserDTO user;
    private String username;
    private String password;

    @Before
    public void setUp() {
        bo = new UserBusiness();
        user = new UserDTO();
        username = "test";
        password = "123456";
        user.setUsername(username);
        user.setPassword(password);
        bo.save(user);
    }
    
    @Test
    public void when_testingLoginWithCorrectData() throws Exception {
        assertTrue(bo.tryUserLogin(username, password) != null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void when_testingLoginWithWrongData() throws Exception {
        assertTrue(bo.tryUserLogin(username, password + "123") == null);
    }
    
    @After
    public void tearDown() throws Exception {
        UserDTO u = bo.tryUserLogin(username, password);
        bo.delete(u);
    }
    
}

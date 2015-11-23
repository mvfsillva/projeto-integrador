/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.business;

import com.ads.projetoIntegrador.dao.IAbstractDAO;
import com.ads.projetoIntegrador.dao.UserDAO;
import com.ads.projetoIntegrador.dto.UserDTO;
import com.ads.projetoIntegrador.utils.PasswordUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yago
 */
public class UserBusiness extends BusinessManager<UserDTO, Integer> {

    @Override
    public IAbstractDAO<UserDTO, Integer> getDAO() {
        if(dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }
    
    
    @Override
    public void save(UserDTO t) {
        String oldPassword = t.getPassword();
        t.setPassword(PasswordUtils.stringToMD5(oldPassword));
        super.save(t); 
    }
    
    @Override
    public void update(UserDTO t) {
        String oldPassword = t.getPassword();
        t.setPassword(PasswordUtils.stringToMD5(oldPassword));
        super.update(t); 
    }
    
    public UserDTO tryUserLogin(String username, String password) throws Exception {
        Map<String, Object> params = new HashMap<>();
        String tempUsername = username.toLowerCase().trim();
        params.put("username", tempUsername);
        params.put("password", PasswordUtils.stringToMD5(password));
        List<UserDTO> result = getDAO().find(UserDTO.FIND_BY_EMAIL_AND_PASS, params);
        if (result.size() == 1) {
            UserDTO user = (UserDTO) result.get(0);
            return user;
        } else {
            throw new IllegalArgumentException("The user or password is wrong");
        }
    }
}

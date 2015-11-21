/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dao;

import com.ads.projetoIntegrador.dto.UserDTO;
import com.ads.projetoIntegrador.utils.PasswordUtils;
import java.util.List;

/**
 *
 * @author yago
 */
public class UserDAO extends AbstractDAO<UserDTO, Integer> {

    public UserDAO() {
        super(UserDTO.class);
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.repository;

import com.ads.projetoIntegrador.entity.UserEntity;

/**
 *
 * @author yago
 */
public class UserRepository extends AbstractRepository<UserEntity, Integer> {

    public UserRepository() {
        super(UserEntity.class);
    }

    
}
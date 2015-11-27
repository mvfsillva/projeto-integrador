/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.repository;

import com.ads.projetoIntegrador.entity.OngEntity;

/**
 *
 * @author arthur
 */
public class OngRepository extends AbstractRepository<OngEntity, Integer>{

    public OngRepository() {
        super(OngEntity.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.repository;

import com.ads.projetoIntegrador.entity.NecessityEntity;

/**
 *
 * @author arthur.hage
 */
public class NecessityRepository extends AbstractRepository<NecessityEntity, Integer>{

    public NecessityRepository() {
        super(NecessityEntity.class);
    }
}

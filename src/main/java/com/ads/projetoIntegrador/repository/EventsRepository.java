/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.repository;

import com.ads.projetoIntegrador.entity.EventsEntity;

/**
 *
 * @author arthur.hage
 */
public class EventsRepository extends AbstractRepository<EventsEntity, Integer>{
    
    public EventsRepository() {
        super(EventsEntity.class);
    }
}

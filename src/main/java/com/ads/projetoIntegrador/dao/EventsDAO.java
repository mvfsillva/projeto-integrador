/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dao;

import com.ads.projetoIntegrador.dto.EventsDTO;

/**
 *
 * @author arthur.hage
 */
public class EventsDAO extends AbstractDAO<EventsDTO, Integer>{
    
    public EventsDAO() {
        super(EventsDTO.class);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.entity;

import java.util.Date;
import java.util.HashSet;

import com.ads.projetoIntegrador.repository.OngRepository;

/**
 *
 * @author arthur
 */
public class TestOngDto {
    
    
    public static void main(String[] args) {
        OngRepository OngDao = new OngRepository();
        OngEntity ong = new OngEntity();
        
        AddressEntity address = new AddressEntity("BA", "Imbui", "rua muito loca", "Salvador city", "41324567", "34568796", null);
        
        ong.setName("Ong teste");
        ong.setCnpj("12345678");
        ong.setEmail("ongTeste@email.com");
        ong.setWebsite("www.ongTeste.com.br");
       
        address.setOng(ong);
        ong.setAddress(address);
        
        NecessityEntity nec1 = new NecessityEntity("comida", "Precisamos comer", "max", new Date());
        nec1.setOng(ong);
        
        NecessityEntity nec2 = new NecessityEntity("roupa", "Precisamos roupas", "max", new Date());
        nec2.setOng(ong);
        
        NecessityEntity nec3 = new NecessityEntity("brinquedos", "Precisamos brinquedos", "media", new Date());
        nec3.setOng(ong);
        
        EventsEntity ev1 = new EventsEntity("Senai Cimatec", "Evento", new Date());
        ev1.setOng(ong);
        
        EventsEntity ev2 = new EventsEntity("Farol da Barra", "Evento", new Date());
        ev2.setOng(ong);
        
        ong.setNecessities(new HashSet<NecessityEntity>());
        ong.getNecessities().add(nec1);
        ong.getNecessities().add(nec2);
        ong.getNecessities().add(nec3);
        
        ong.setEvents(new HashSet<EventsEntity>());
        ong.getEvents().add(ev1);
        ong.getEvents().add(ev2);
        
        OngDao.save(ong);
    }
}

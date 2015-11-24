/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dto;

import com.ads.projetoIntegrador.dao.OngDAO;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author arthur
 */
public class TestOngDto {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        OngDAO OngDao = new OngDAO();
        OngDTO ong = new OngDTO();
        
        AddressDTO address = new AddressDTO("BA", "Imbui", "rua muito loca", "Salvador city", "41324567", "34568796", null);
        
        ong.setName("Ong teste");
        ong.setCnpj("12345678");
        ong.setEmail("ongTeste@email.com");
        ong.setWebsite("www.ongTeste.com.br");
       
        address.setOng(ong);
        ong.setAddress(address);
        
        NecessityDTO nec1 = new NecessityDTO("comida", "Precisamos comer", "max", new Date());
        nec1.setOng(ong);
        
        NecessityDTO nec2 = new NecessityDTO("roupa", "Precisamos roupas", "max", new Date());
        nec2.setOng(ong);
        
        NecessityDTO nec3 = new NecessityDTO("brinquedos", "Precisamos brinquedos", "media", new Date());
        nec3.setOng(ong);
        
        ong.setNecessities(new HashSet<NecessityDTO>());
        ong.getNecessities().add(nec1);
        ong.getNecessities().add(nec2);
        ong.getNecessities().add(nec3);
        
        OngDao.save(ong);
    }
}

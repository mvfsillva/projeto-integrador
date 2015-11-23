/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dto;

import com.ads.projetoIntegrador.dao.AddressDAO;
import com.ads.projetoIntegrador.dao.NecessityDAO;
import com.ads.projetoIntegrador.dao.OngDAO;
import com.ads.projetoIntegrador.dto.AddressDTO;
import com.ads.projetoIntegrador.dto.NecessityDTO;
import com.ads.projetoIntegrador.dto.OngDTO;
import java.util.Date;

/**
 *
 * @author arthur
 */
public class TestOngDto {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        OngDAO OngDao = new OngDAO();
        OngDTO ong = new OngDTO();
        
        AddressDAO AddressDao = new AddressDAO();
        NecessityDAO NecessityDao = new NecessityDAO();
        
        AddressDTO address = new AddressDTO("BA", "Imbui", "rua muito loca", "Salvador city", "41324567", "34568796", null);
        NecessityDTO nec1 = new NecessityDTO("comida", "Precisamos comer", "max", new Date());
        NecessityDTO nec2 = new NecessityDTO("roupa", "Precisamos roupas", "max", new Date());
        NecessityDTO nec3 = new NecessityDTO("brinquedos", "Precisamos brinquedos", "media", new Date());
        
        ong.setName("Ong teste");
        ong.setCnpj("12345678");
        ong.setEmail("ongTeste@email.com");
        ong.setWebsite("www.ongTeste.com.br");
        ong.setOng_address(address);
        
        nec1.setOng(ong);
        nec2.setOng(ong);
        nec3.setOng(ong);
        
        AddressDao.save(address);
        NecessityDao.save(nec1);
        NecessityDao.save(nec2);
        NecessityDao.save(nec3);
        OngDao.save(ong);
    }
}

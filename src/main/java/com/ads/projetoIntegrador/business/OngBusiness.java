/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.business;

import com.ads.projetoIntegrador.entity.OngEntity;
import com.ads.projetoIntegrador.repository.OngRepository;

/**
 *
 * @author MarcusSilva
 */
public class OngBusiness extends AbstractBusiness<OngEntity, Integer>{

    public OngBusiness() {
        this.repository = new OngRepository();
    }
    
}

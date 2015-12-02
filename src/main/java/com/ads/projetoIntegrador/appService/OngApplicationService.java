/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.appService;

import com.ads.projetoIntegrador.business.OngBusiness;
import com.ads.projetoIntegrador.entity.OngEntity;

/**
 *
 * @author MarcusSilva
 */
public class OngApplicationService extends  AbstractApplicationService<OngEntity, Integer>{

    public OngApplicationService() {
        this.business = new OngBusiness();
    }
    
}

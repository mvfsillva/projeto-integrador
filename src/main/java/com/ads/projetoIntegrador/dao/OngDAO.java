/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dao;

import com.ads.projetoIntegrador.dto.OngDTO;
import java.io.Serializable;

/**
 *
 * @author arthur
 */
public class OngDAO extends AbstractDAO<OngDTO, Integer>{

    public OngDAO() {
        super(OngDTO.class);
    }
    
}

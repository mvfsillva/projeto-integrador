/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dao;

import com.ads.projetoIntegrador.dto.NecessityDTO;

/**
 *
 * @author arthur.hage
 */
public class NecessityDAO extends AbstractDAO<NecessityDTO, Integer>{

    public NecessityDAO() {
        super(NecessityDTO.class);
    }
}

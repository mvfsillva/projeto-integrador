/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dao;

import com.ads.projetoIntegrador.dto.EnderecoDTO;


/**
 *
 * @author arthur.hage
 */
public class EnderecoDAO extends AbstractDAO<EnderecoDTO, Integer> {

    public EnderecoDAO() {
        super(EnderecoDTO.class);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.test;

import com.ads.projetoIntegrador.dao.AbstractDAO;

/**
 *
 * @author Yago Ferreira
 */
public class PersonDAO extends AbstractDAO<PersonTestDTO, Integer> {

    public PersonDAO() {
        super(PersonTestDTO.class);
    }

}

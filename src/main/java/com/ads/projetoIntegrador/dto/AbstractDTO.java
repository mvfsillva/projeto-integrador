/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dto;

import java.io.Serializable;

/**
 *
 * @author Yago Ferreira
 * @param <KeyType>
 */
public abstract class AbstractDTO<KeyType> implements Serializable {
    
    public abstract KeyType getId();
    
    public abstract void setId(KeyType id);
}

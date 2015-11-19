/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author arthur.hage
 */

@Entity
@Table(name = "tb_address", schema = "public")
public class AddressDTO implements Serializable{
    
    @Id
    @Column(name = "id_address", nullable = false, unique = true)
    @SequenceGenerator(name = "id_address_sq", sequenceName = "sq_address_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_address_sq")
    private Integer id;
    
    @Column(name = "address_city", nullable = false)
    private String city;
    
    @Column(name = "address_state", nullable = false)
    private String state;
    
    @Column(name = "address_neighborhood", nullable = false)
    private String neighborhood;
    
    @Column(name = "address_street", nullable = false)
    private String street;
    
    @Column(name = "address_postal_code", nullable = false)
    private String postal_code;
    
    @Column(name = "address_primary_phone", nullable = false)
    private String primary_phone;
    
    @Column(name = "address_secondary_phone")
    private String secondary_phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }
    
     public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPrimary_phone() {
        return primary_phone;
    }

    public void setPrimary_phone(String primary_phone) {
        this.primary_phone = primary_phone;
    }

    public String getSecondary_phone() {
        return secondary_phone;
    }

    public void setSecondary_phone(String secondary_phone) {
        this.secondary_phone = secondary_phone;
    }
    
    @Override
    public String toString() {
        return "Cidade: " + this.city + " Estado: " + this.state + " Bairro: " + this.neighborhood
                + " Rua: " + this.street + " Cep: " + this.postal_code + " Telefone Primario: " + this.primary_phone 
                + " Telefone Secundario: " + this.secondary_phone ;
    }
    
}

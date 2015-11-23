/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dto;

import com.ads.projetoIntegrador.dto.NecessityDTO;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author arthur
 */
@Entity
@Table(name = "tb_ong", schema = "public")
public class OngDTO implements Serializable{
    
    @Id
    @Column(name = "id_ong", nullable = false, unique = true)
    @SequenceGenerator(name = "id_ong_sq", sequenceName = "sq_ong_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_ong_sq")
    private Integer id;
    
    @Column(name = "ong_cnpj", nullable = false, unique = true)
    //CNPJ  – Brazilian Registration of Corporate Taxpayers
    private String cnpj;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="ong_address_id")
    private AddressDTO ong_address;
    
    @Column(name = "ong_name", nullable = false)
    private String name;
    
    @Column(name = "ong_email", nullable = false)
    private String email;
    
    @Column(name = "ong_website", nullable = false)
    private String website;
    
    //necessity
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = NecessityDTO.class, mappedBy="ong")
    private Set<NecessityDTO> necessities = new HashSet<>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public AddressDTO getOng_address() {
        return ong_address;
    }

    public void setOng_address(AddressDTO ong_address) {
        this.ong_address = ong_address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Set<NecessityDTO> getNecessities() {
        return necessities;
    }

    public void setNecessities(Set<NecessityDTO> necessities) {
        this.necessities = necessities;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    
}

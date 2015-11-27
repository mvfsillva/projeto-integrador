/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType; 

/**
 *
 * @author arthur
 */
@Entity
@Table(name = "tb_ong", schema = "public")
public class OngEntity implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8348124056614554485L;

	@Id
    @Column(name = "id_ong", nullable = false, unique = true)
    @SequenceGenerator(name = "id_ong_sq", sequenceName = "sq_ong_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_ong_sq")
    private Integer id;
    
    //CNPJ  – Brazilian Registration of Corporate Taxpayers
    @Column(name = "ong_cnpj", nullable = false, unique = true)
    private String cnpj;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "ong")
    @Cascade(CascadeType.ALL)
    private AddressEntity address;
    
    @Column(name = "ong_name", nullable = false)
    private String name;
    
    @Column(name = "ong_email", nullable = false)
    private String email;
    
    @Column(name = "ong_website", nullable = false)
    private String website;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="ong")
    @Cascade(CascadeType.ALL)
    private Collection<NecessityEntity> necessities;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="ong")
    @Cascade(CascadeType.ALL)
    private Collection<EventsEntity> events;

    public OngEntity() {
    }

    public OngEntity(String cnpj, String name, String email, String website, Collection<NecessityEntity> necessities
            , Collection<EventsEntity> events) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.website = website;
        this.necessities = necessities;
        this.events = events;
    }

    public OngEntity(String cnpj, AddressEntity address, String name, String email, String website
            , Collection<NecessityEntity> necessities, Collection<EventsEntity> events) {
        this.cnpj = cnpj;
        this.address = address;
        this.name = name;
        this.email = email;
        this.website = website;
        this.necessities = necessities;
        this.events = events;
    }
    
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
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
    
    public Collection<NecessityEntity> getNecessities() {
        return necessities;
    }

    public void setNecessities(Collection<NecessityEntity> necessities) {
        this.necessities = necessities;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    
    public Collection<EventsEntity> getEvents() {
        return events;
    }

    public void setEvents(Collection<EventsEntity> events) {
        this.events = events;
    }
    
}

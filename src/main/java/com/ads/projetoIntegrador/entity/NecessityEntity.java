/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author arthur.hage
 */

@Entity
@Table(name = "tb_necessity", schema = "public")
public class NecessityEntity implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6255015039723910221L;

	@Id
    @Column(name = "id_necessity", nullable = false, unique = true)
    @SequenceGenerator(name = "id_necessity_sq", sequenceName = "sq_necessity_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_necessity_sq")
    private Integer id;
    
    @Column(name = "necessity_description", nullable = false)
    private String description;
    
    @Column(name = "necessity_title", nullable = false)
    private String title;
    
    @Column(name = "necessity_priority", nullable = false)
    private String priority;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "necessity_date", nullable = false, length = 10)
    private Date date;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="ong_id", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    private OngEntity ong;

    public NecessityEntity() {
    }

    public NecessityEntity(String description, String title, String priority, Date date) {
        this.description = description;
        this.title = title;
        this.priority = priority;
        this.date = date;
    }
    
     public NecessityEntity(String description, String title, String priority
             , Date date, OngEntity ong) {
        this.description = description;
        this.title = title;
        this.priority = priority;
        this.date = date;
        this.ong = ong;
    }
    
    public OngEntity getOng() {
        return this.ong;
    }

    public void setOng(OngEntity ong) {
        this.ong = ong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return "Description: " + this.description + " title: " + this.title 
                + " priority: " + this.priority + " date: " + this.date;
    }
}

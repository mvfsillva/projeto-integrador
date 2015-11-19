/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.dto;

import java.io.Serializable;
//import java.util.Date;
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
@Table(name = "tb_necessity", schema = "public")
public class NecessityDTO implements Serializable{
    
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
    
    @Column(name = "necessity_date", nullable = false)
    private String date;
//    private Date date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return "Description: " + this.description + " title: " + this.title 
                + " priority: " + this.priority + " date: " + this.date;
    }
}

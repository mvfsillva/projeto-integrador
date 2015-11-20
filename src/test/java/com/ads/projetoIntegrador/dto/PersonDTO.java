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
 * @author Yago Ferreira
 */
@Entity
@Table(name = "person", schema = "public")
public class PersonDTO implements Serializable {

    @Id
    @Column(name = "id_person", nullable = false, unique = true)
    @SequenceGenerator(name = "id_person_sq", sequenceName = "sq_person_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_person_sq")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + this.name;
    }
}

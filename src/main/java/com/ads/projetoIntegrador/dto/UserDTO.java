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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author yago
 */
@Entity
@NamedQueries(value = {
    @NamedQuery(name = "findByEmailAndPass",
            query = "SELECT c FROM user c WHERE c.username = :username AND c.password = :password")})
@Table(name = "system_user")
public class UserDTO implements Serializable {

    @Transient
    public static final String FIND_BY_EMAIL_AND_PASS = "findByEmailAndPass";

    @Id
    @Column(name = "id_address", nullable = false, unique = true)
    @SequenceGenerator(name = "id_user_sq", sequenceName = "sq_user_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_user_sq")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

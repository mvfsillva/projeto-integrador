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
@Table(name = "endereco", schema = "public")
public class EnderecoDTO implements Serializable{
    
    @Id
    @Column(name = "id_end", nullable = false, unique = true)
    @SequenceGenerator(name = "id_end_sq", sequenceName = "sq_end_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_end_sq")
    private Integer id;
    
    @Column(name = "cidade", nullable = false)
    private String cidade;
    
    @Column(name = "estado", nullable = false)
    private String estado;
    
    @Column(name = "bairro", nullable = false)
    private String bairro;
    
    @Column(name = "rua", nullable = false)
    private String rua;
    
    @Column(name = "cep", nullable = false)
    private String cep;
    
    @Column(name = "telefone_primario", nullable = false)
    private String telefone_primario;
    
    @Column(name = "telefone_secundario", nullable = true)
    private String telefone_secndario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone_primario() {
        return telefone_primario;
    }

    public void setTelefone_primario(String telefone_primario) {
        this.telefone_primario = telefone_primario;
    }

    public String getTelefone_secndario() {
        return telefone_secndario;
    }

    public void setTelefone_secndario(String telefone_secndario) {
        this.telefone_secndario = telefone_secndario;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    @Override
    public String toString() {
        return "Cidade: " + this.cidade + " Estado: " + this.estado + " Bairro: " + this.bairro
                + " Rua: " + this.rua + " Cep: " + this.cep + " Telefone Primario: " + this.telefone_primario 
                + " Telefone Secundario: " + this.telefone_secndario ;
    }
    
}

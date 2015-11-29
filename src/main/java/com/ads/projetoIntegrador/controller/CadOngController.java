/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.controller;
import com.ads.projetoIntegrador.entity.AddressEntity;
import com.ads.projetoIntegrador.entity.OngEntity;
import com.ads.projetoIntegrador.repository.AddressRepository;
import com.ads.projetoIntegrador.repository.OngRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author arthur
 */
@ManagedBean(name = "cadOngController")
@SessionScoped
public class CadOngController {
    
    private AddressRepository addressRepository = new AddressRepository();
    private OngRepository ongRepository = new OngRepository();
    private AddressEntity address;
    private OngEntity ong;
    private List<OngEntity> ongs;

    public CadOngController() {
        this.address = new AddressEntity();
        this.ong = new OngEntity();
    }
    
    public OngEntity getOng() {
        return ong;
    }

    public AddressEntity getAddress() {
        return address;
    }
    
    public void save (){
        System.out.println("salvou");
    }
    
}

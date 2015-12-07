package org.doando.controller;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.doando.appService.OngApplicationService;
import org.doando.appService.StateAppService;
import org.doando.entity.AddressEntity;
import org.doando.entity.EventsEntity;
import org.doando.entity.NecessityEntity;
import org.doando.entity.OngEntity;
import org.doando.entity.StateEntity;

/**
 *
 * @author arthur
 */
@ManagedBean(name = "cadOngController")
@SessionScoped
public class CadOngController {
    
    private OngApplicationService ongAppService;
    private AddressEntity address;
    private OngEntity ong;
    private List<OngEntity> ongs;
    private List<StateEntity> states;
    private StateAppService stateAppService;
    
    public CadOngController() {
        this.ongAppService = new OngApplicationService();
        this.address = new AddressEntity();
        this.ong = new OngEntity();
        this.stateAppService = new StateAppService();
    }
    
    public OngEntity getOng() {
        return ong;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public List<OngEntity> getOngs() throws SQLException, ClassNotFoundException {
        if(ongs == null){
            this.ongs = ongAppService.find();
        }
        return ongs;
    }

    public void setOngs(List<OngEntity> ongs) {
        this.ongs = ongs;
    }
    
    public List<StateEntity> getStates() {
    	if (states == null) {
    		this.states = stateAppService.find();
		}
        return states;
    }

    public void setStates(List<StateEntity> states) {
        this.states = states;
    }
    
    public void clear (){
        this.ong = null;
        this.address = null;
    }
    
    public void save() throws SQLException,  ClassNotFoundException{
        address.setOng(ong);
        ong.setAddress(address);
        ong.setNecessities(new HashSet<NecessityEntity>());
        ong.setEvents(new HashSet<EventsEntity>());
        ongAppService.save(ong);
        clear ();
    }
    
    public void loadCities() {
        
    }
    
}

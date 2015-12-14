package org.doando.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.doando.appService.OngApplicationService;
import org.doando.entity.AddressEntity;
import org.doando.entity.EventsEntity;
import org.doando.entity.NecessityEntity;
import org.doando.entity.OngEntity;
import org.doando.utils.PostalCodeService;

/**
 *
 * @author arthur
 */
@ManagedBean(name = "cadOngController")
@ViewScoped
public class CadOngController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6006035867967167391L;
	
	private String cep;
	private OngEntity ong;
	private List<OngEntity> ongs;
	private AddressEntity address;
	private PostalCodeService postalCodeService;
	private OngApplicationService ongAppService;

	public CadOngController() {
            this.ong = new OngEntity();
            this.address = new AddressEntity();
            this.ongAppService = new OngApplicationService();
            this.postalCodeService = new PostalCodeService();
            init();
	}

	public OngEntity getOng() {
            return ong;
	}

	public AddressEntity getAddress() {
            return address;
	}

	public List<OngEntity> getOngs() throws SQLException, ClassNotFoundException {
            return ongs;
	}

	public String getCep() {
            return cep;
	}

	public void setCep(String cep) {
            this.cep = cep;
	}

	public void setOngs(List<OngEntity> ongs) {
            this.ongs = ongs;
	}

	public void clear() {
            this.ong = new OngEntity();
            this.address = new AddressEntity();
	}

	public String save() throws SQLException, ClassNotFoundException {
            address.setOng(ong);
            ong.setAddress(address);
            ong.setNecessities(new HashSet<NecessityEntity>());
            ong.setEvents(new HashSet<EventsEntity>());
            ongAppService.save(ong);
            init();
            clear();
            return "/ong/cadOng.xhtml?faces-redirect=true";
	}

	private void init() {
		this.ongs = ongAppService.find();
	}

	public String delete(String ong) {
            OngEntity ongToDelete = ongAppService.find(ong);
            ongAppService.delete(ongToDelete);
            return "/ong/cadOng.xhtml?faces-redirect=true";
	}

	public String findCep() throws Exception {
		postalCodeService.find(cep);
		this.address = postalCodeService.getAddress();
		return "";
	}
}

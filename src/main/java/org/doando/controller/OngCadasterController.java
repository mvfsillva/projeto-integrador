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
import org.doando.session.SessionContext;
import org.doando.utils.PostalCodeService;

@ManagedBean(name = "ongCadasterController")
@ViewScoped
public class OngCadasterController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7342160760556080297L;

	private String cep;
	private OngEntity ong;
	private List<OngEntity> ongs;
	private AddressEntity address;
	private PostalCodeService postalCodeService;
	private OngApplicationService ongAppService;
	private String singUpButtonText;
	
	public OngCadasterController() {
		this.address = new AddressEntity();
		this.postalCodeService = new PostalCodeService();
		this.ongAppService = new OngApplicationService();
		init();
	}
	
	public OngEntity getOng() {
		return ong;
	}

	public AddressEntity getAddress() {
		return address;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void clear() {
		this.ong = new OngEntity();
		this.address = new AddressEntity();
	}
	
	public List<OngEntity> getOngs() throws SQLException, ClassNotFoundException {
		return ongs;
	}
	
	public void setOngs(List<OngEntity> ongs) {
		this.ongs = ongs;
	}
	
	public String getSingUpButtonText() {
		return singUpButtonText;
	}

	public void setSingUpButtonText(String singUpButtonText) {
		this.singUpButtonText = singUpButtonText;
	}

	public String save() throws SQLException, ClassNotFoundException {
		address.setOng(ong);
		ong.setAddress(address);
		ong.setNecessities(new HashSet<NecessityEntity>());
		ong.setEvents(new HashSet<EventsEntity>());
		ongAppService.save(ong);
		init();
		clear();
		return "/ong/ong.xhtml?faces-redirect=true";
	}
	
	public String findCep() throws Exception {
		postalCodeService.find(cep);
		this.address = postalCodeService.getAddress();
		return "";
	}
	
	private void init() {
		this.ongs = ongAppService.find();
		this.ong = SessionContext.getInstance().getLoggedInOng();
		if (this.ong == null) {
			this.singUpButtonText = "Ingressar no Doando.org";
			this.ong = new OngEntity();
		} else {
			this.singUpButtonText = "Ver detalhes de " + this.ong.getName();
		}
	}
	
}

package org.doando.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.doando.appService.OngApplicationService;
import org.doando.entity.OngEntity;

/**
 *
 * @author arthur
 */
@ManagedBean(name = "cardOngController")
@ViewScoped
public class CardOngController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6006035867967167391L;

	
	private String name;
	private List<OngEntity> ongs;
	private OngApplicationService ongAppService;

	public CardOngController() {
		this.ongAppService = new OngApplicationService();
		this.ongs = ongAppService.find();
	}

	public List<OngEntity> getOngs() throws SQLException, ClassNotFoundException {
		return ongs;
	}
	
	public void setOngs(List<OngEntity> ongs) {
		this.ongs = ongs;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String delete(OngEntity ong) {
		ongAppService.delete(ong);
		return "/ong/ong.xhtml?faces-redirect=true";
	}

	public String search() throws Exception {
		if (!"".equals(name)) {
			this.ongs = ongAppService.search(name);
		} else {
			this.ongs = ongAppService.find();
		}
		return "";
	}
}

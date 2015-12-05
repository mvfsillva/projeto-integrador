package org.doando.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "state")
public class StateEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9160121629637018860L;

	@Id
	@Column(name = "id_state", nullable = false)
	private Integer id;
	
	@Column(name = "description", nullable = false)
	private String description;

	@Transient
	private List<CityEntity> cities;
	
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

	public List<CityEntity> getCities() {
		return cities;
	}

	public void setCities(List<CityEntity> cities) {
		this.cities = cities;
	}
	
}

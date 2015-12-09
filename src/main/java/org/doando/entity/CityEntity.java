package org.doando.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7854866215212857907L;
	
	@Id
	@Column(name = "id_city", nullable = false)
	private Integer id;
	
	@Column(name = "description", unique = true, nullable = false)
	private String description;
	
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
}

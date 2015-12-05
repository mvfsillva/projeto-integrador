package org.doando.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(value = {
	    @NamedQuery(name = "findByState",
	            query = "SELECT c FROM CityEntity c WHERE c.id_state :id")})
@Table(name = "city")
public class CityEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7854866215212857907L;
	
	public static final String FIND_BY_STATE = "findByState";

	@Id
	@Column(name = "id_state", nullable = false)
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

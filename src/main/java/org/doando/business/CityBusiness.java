package org.doando.business;

import java.util.List;

import org.doando.entity.CityEntity;
import org.doando.repository.CityRepository;

public class CityBusiness extends AbstractBusiness<CityEntity, Integer> {

	public CityBusiness() {
		this.repository = new CityRepository();
	}
	
	public List<CityEntity> findByState(Integer id) {
		return ((CityRepository) repository).findByState(id);
	}
}

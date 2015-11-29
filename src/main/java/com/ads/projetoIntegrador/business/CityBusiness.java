package com.ads.projetoIntegrador.business;

import java.util.List;

import com.ads.projetoIntegrador.entity.CityEntity;
import com.ads.projetoIntegrador.repository.CityRepository;

public class CityBusiness extends AbstractBusinessManager<CityEntity, Integer> {

	public CityBusiness() {
		this.repository = new CityRepository();
	}
	
	public List<CityEntity> findByState(Integer id) {
		return ((CityRepository) repository).findByState(id);
	}
}

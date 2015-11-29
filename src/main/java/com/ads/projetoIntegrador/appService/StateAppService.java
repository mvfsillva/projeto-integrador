package com.ads.projetoIntegrador.appService;

import java.util.List;

import com.ads.projetoIntegrador.business.CityBusiness;
import com.ads.projetoIntegrador.business.StateBusiness;
import com.ads.projetoIntegrador.entity.CityEntity;
import com.ads.projetoIntegrador.entity.StateEntity;

public class StateAppService extends AbstractApplicationService<StateEntity, Integer> {

	private CityBusiness cityBo;
	
	public StateAppService() {
		this.cityBo = new CityBusiness();
		this.business = new StateBusiness();
	}
	
	private List<CityEntity> findByState(Integer id) {
		return cityBo.findByState(id);
	}

	@Override
	public StateEntity find(Integer id) {
		StateEntity e = super.find(id);
		e.setCities(findByState(id));
		return e;
	}

}

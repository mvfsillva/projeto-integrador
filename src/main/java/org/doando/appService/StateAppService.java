package org.doando.appService;

import java.util.List;

import org.doando.business.CityBusiness;
import org.doando.business.StateBusiness;
import org.doando.entity.CityEntity;
import org.doando.entity.StateEntity;


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

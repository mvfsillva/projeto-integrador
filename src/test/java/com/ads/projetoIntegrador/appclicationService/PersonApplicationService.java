package com.ads.projetoIntegrador.appclicationService;

import com.ads.projetoIntegrador.appService.AbstractApplicationService;
import com.ads.projetoIntegrador.business.PersonBusiness;
import com.ads.projetoIntegrador.entity.PersonEntity;

public class PersonApplicationService extends AbstractApplicationService<PersonEntity, Integer> {

	public PersonApplicationService() {
		super();
		this.business = new PersonBusiness();
	}
	
	public PersonEntity find(String name) {
		initialize();
		PersonEntity p = ((PersonBusiness) business).find(name);
		cleanUp();
		return p;
	}
	
}

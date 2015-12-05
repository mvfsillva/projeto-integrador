package org.doando.appclicationService;

import org.doando.appService.AbstractApplicationService;
import org.doando.business.PersonBusiness;
import org.doando.entity.PersonEntity;

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

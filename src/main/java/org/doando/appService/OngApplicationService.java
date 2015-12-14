
package org.doando.appService;

import org.doando.business.OngBusiness;
import org.doando.entity.OngEntity;

/**
 *
 * @author MarcusSilva
 */
public class OngApplicationService extends AbstractApplicationService<OngEntity, Integer> {

	public OngApplicationService() {
		this.business = new OngBusiness();
	}

	public OngEntity find(String email, String cnpj) {
		initialize();
		OngEntity p = ((OngBusiness) business).find(email, cnpj);
		cleanUp();
		return p;
	}
	
}

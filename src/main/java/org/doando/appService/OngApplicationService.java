
package org.doando.appService;

import java.util.List;
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
        
        public List<OngEntity> search (String name){
            initialize();
            List<OngEntity> p = ((OngBusiness) business).search(name);
            cleanUp();
            return p;
        }
	
}

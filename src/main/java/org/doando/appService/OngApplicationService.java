
package org.doando.appService;

import org.doando.business.OngBusiness;
import org.doando.entity.OngEntity;

/**
 *
 * @author MarcusSilva
 */
public class OngApplicationService extends  AbstractApplicationService<OngEntity, Integer>{

	private AddressApplicationService addressAppService;
//	private NecessityAppService necessityAppService;
//	private EventsAppSerice eventsAppService;
	
    public OngApplicationService() {
        this.business = new OngBusiness();
    }
    
    public OngEntity find(String name) {
        initialize();
        OngEntity p = ((OngBusiness) business).find(name);
        cleanUp();
        return p;
    }
}

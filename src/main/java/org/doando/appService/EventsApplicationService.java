package org.doando.appService;

import org.doando.entity.EventsEntity;
import org.doando.business.EventsBusiness;

/**
 *
 * @author arthur
 */
public class EventsApplicationService extends AbstractApplicationService<EventsEntity, Integer> {

    public EventsApplicationService() {
	this.business = new EventsBusiness();
    }
    
    public EventsEntity find(String name) {
        initialize();
        EventsEntity p = ((EventsBusiness) business).find(name);
        cleanUp();
        return p;
    }
}

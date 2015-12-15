package org.doando.business;

import org.doando.entity.EventsEntity;
import org.doando.repository.EventsRepository;

/**
 *
 * @author arthur
 */
public class EventsBusiness extends AbstractBusiness<EventsEntity, Integer>{

    public EventsBusiness() {
        this.repository = new EventsRepository();
    }
    
}

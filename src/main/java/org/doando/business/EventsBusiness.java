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
    
    @Override
    public void validate(EventsEntity t) {
        super.validate(t);
        if (t.getName().isEmpty()) {
            throw new IllegalArgumentException("the name is empty");
        }
    }

    public EventsEntity find(String name) {
	return ((EventsRepository) getRepository()).find(name);
    }
    
}

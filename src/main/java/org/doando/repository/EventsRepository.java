package org.doando.repository;

import org.doando.entity.EventsEntity;

/**
 *
 * @author arthur.hage
 */
public class EventsRepository extends AbstractRepository<EventsEntity, Integer>{
    
    public EventsRepository() {
        super(EventsEntity.class);
    }
}

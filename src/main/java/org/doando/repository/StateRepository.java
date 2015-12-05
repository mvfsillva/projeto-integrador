package org.doando.repository;

import org.doando.entity.StateEntity;

/**
 *
 * @author Yago Ferreira
 */
public class StateRepository extends AbstractRepository<StateEntity, Integer> {

    public StateRepository() {
        super(StateEntity.class);
    }
    
}

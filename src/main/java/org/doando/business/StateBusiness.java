package org.doando.business;

import org.doando.entity.StateEntity;
import org.doando.repository.StateRepository;

public class StateBusiness extends AbstractBusiness<StateEntity, Integer> {

    public StateBusiness() {
        this.repository = new StateRepository();
    }
}

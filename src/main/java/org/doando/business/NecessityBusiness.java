package org.doando.business;

import org.doando.entity.NecessityEntity;
import org.doando.repository.NecessityRepository;

/**
 *
 * @author arthur
 */
public class NecessityBusiness extends AbstractBusiness<NecessityEntity, Integer>{

    public NecessityBusiness() {
        this.repository = new NecessityRepository();
    }
}

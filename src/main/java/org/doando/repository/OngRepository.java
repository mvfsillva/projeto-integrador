package org.doando.repository;

import org.doando.entity.OngEntity;

/**
 *
 * @author arthur
 */
public class OngRepository extends AbstractRepository<OngEntity, Integer>{

    public OngRepository() {
        super(OngEntity.class);
    }
    
}

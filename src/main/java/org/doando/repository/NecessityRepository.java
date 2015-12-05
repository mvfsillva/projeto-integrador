package org.doando.repository;

import org.doando.entity.NecessityEntity;

/**
 *
 * @author arthur.hage
 */
public class NecessityRepository extends AbstractRepository<NecessityEntity, Integer>{

    public NecessityRepository() {
        super(NecessityEntity.class);
    }
}

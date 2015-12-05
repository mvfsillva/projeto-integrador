package org.doando.repository;

import org.doando.entity.AddressEntity;


/**
 *
 * @author arthur.hage
 */
public class AddressRepository extends AbstractRepository<AddressEntity, Integer> {

    public AddressRepository() {
        super(AddressEntity.class);
    }
}

package org.doando.repository;

import org.doando.entity.UserEntity;

/**
 *
 * @author yago
 */
public class UserRepository extends AbstractRepository<UserEntity, Integer> {

    public UserRepository() {
        super(UserEntity.class);
    }

    
}

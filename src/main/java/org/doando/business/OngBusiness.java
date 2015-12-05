package org.doando.business;

import org.doando.entity.OngEntity;
import org.doando.repository.OngRepository;

/**
 *
 * @author MarcusSilva
 */
public class OngBusiness extends AbstractBusiness<OngEntity, Integer>{

    public OngBusiness() {
        this.repository = new OngRepository();
    }
    
}

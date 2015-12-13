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
    
    @Override
    public void validate(OngEntity t) {
        super.validate(t);
        if (t.getName().isEmpty()) {
            throw new IllegalArgumentException("the name is empty");
        }
    }

    public OngEntity find(String name) {
	return ((OngRepository) getRepository()).find(name);
    }
    
}

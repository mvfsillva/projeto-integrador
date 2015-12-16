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
    
    @Override
    public void validate(NecessityEntity t) {
        super.validate(t);
        if (t.getOngName().isEmpty()) {
            throw new IllegalArgumentException("the name is empty");
        }
    }

    public NecessityEntity find(String ongName) {
	return ((NecessityRepository) getRepository()).find(ongName);
    }
}

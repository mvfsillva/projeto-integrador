package org.doando.business;

import org.doando.entity.VoluntaryEntity;
import org.doando.repository.VoluntaryRepository;

/**
 *
 * @author arthur
 */
public class VoluntaryBusiness  extends AbstractBusiness<VoluntaryEntity, Integer> {

    public VoluntaryBusiness() {
        this.repository = new VoluntaryRepository();
    }
    
    @Override
    public void validate(VoluntaryEntity t) {
        super.validate(t);
        if (t.getName().isEmpty()) {
            throw new IllegalArgumentException("the name is empty");
        }
    }

    public VoluntaryEntity find(String name) {
	return ((VoluntaryRepository) getRepository()).find(name);
    }
    
}

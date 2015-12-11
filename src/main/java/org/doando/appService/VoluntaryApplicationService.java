package org.doando.appService;

import org.doando.entity.VoluntaryEntity;
import org.doando.business.VoluntaryBusiness;

/**
 *
 * @author arthur
 */
public class VoluntaryApplicationService extends  AbstractApplicationService<VoluntaryEntity, Integer> {
    
    public VoluntaryApplicationService () {
        this.business = new VoluntaryBusiness();
    }
    
    public VoluntaryEntity find(String name) {
        initialize();
        VoluntaryEntity p = ((VoluntaryBusiness) business).find(name);
        cleanUp();
        return p;
    }
    
}

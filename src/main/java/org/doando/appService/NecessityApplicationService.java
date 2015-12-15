package org.doando.appService;

import org.doando.business.NecessityBusiness;
import org.doando.entity.NecessityEntity;

/**
 *
 * @author arthur
 */
public class NecessityApplicationService extends AbstractApplicationService<NecessityEntity, Integer> {

    public NecessityApplicationService() {
	this.business = new NecessityBusiness();
    }
}

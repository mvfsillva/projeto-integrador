
package org.doando.appService;

import java.io.Serializable;
import java.util.List;

import org.doando.business.OngBusiness;
import org.doando.entity.OngEntity;

/**
 *
 * @author MarcusSilva
 */
public class OngApplicationService extends AbstractApplicationService<OngEntity, Integer> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3362608207676880593L;

	public OngApplicationService() {
		this.business = new OngBusiness();
	}

	public OngEntity find(String email, String cnpj) {
		initialize();
		OngEntity p = ((OngBusiness) business).find(email, cnpj);
		cleanUp();
		return p;
	}
        
        public List<OngEntity> search (String name){
            initialize();
            List<OngEntity> p = ((OngBusiness) business).search(name);
            cleanUp();
            return p;
        }
	
	@Override
	public void save(OngEntity t) {
		initialize();
		try {
			beginTransaction();
			try {
				((OngBusiness) business).save(t);
				commit();
			} catch (Exception ex) {
				// Log the exception here
				rollback();
				throw ex;
			}
		} finally {
			cleanUp();
		}
	}
	
	@Override
	public void update(OngEntity t) {
		initialize();
		try {
			beginTransaction();
			try {
				((OngBusiness) business).update(t);
				commit();
			} catch (Exception ex) {
				// Log the exception here
				rollback();
				throw ex;
			}
		} finally {
			cleanUp();
		}
	}
	
	public OngEntity tryToLogin(String email, String password) throws Exception {
		initialize();
		OngEntity o = ((OngBusiness) business).tryToLogin(email, password);
		cleanUp();
		return o;
	}
}

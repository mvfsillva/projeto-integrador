package org.doando.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.doando.entity.OngEntity;
import org.doando.exception.InvallidEmailOrCnpjException;
import org.doando.repository.OngRepository;
import org.doando.utils.PasswordUtils;

/**
 *
 * @author MarcusSilva
 */
public class OngBusiness extends AbstractBusiness<OngEntity, Integer>{

    public OngBusiness() {
        this.repository = new OngRepository();
    }
    
    @Override
    public void validate(OngEntity t) throws InvallidEmailOrCnpjException {
        super.validate(t);
        if (t.getName().isEmpty()) {
            throw new IllegalArgumentException("The name is empty");
        } 
        OngEntity r = find(t.getEmail(), t.getCnpj());
        if(r != null) {
        	throw new InvallidEmailOrCnpjException("Email or CNPJ already in the system");
        }
    }

    public OngEntity find(String name, String cnpj) {
    	return ((OngRepository) getRepository()).find(name, cnpj);
    }
    
    @Override
	public int save(OngEntity t) {
		String oldPassword = t.getPassword();
		t.setPassword(PasswordUtils.stringToMD5(oldPassword));
		return super.save(t);
	}

	@Override
	public void update(OngEntity t) {
		String oldPassword = t.getPassword();
		t.setPassword(PasswordUtils.stringToMD5(oldPassword));
		super.update(t);
	}

	public OngEntity tryToLogin(String email, String password) throws Exception {
		Map<String, Object> params = new HashMap<>();
		String tempEmail = email.toLowerCase().trim();
		params.put("email", tempEmail);
		params.put("password", PasswordUtils.stringToMD5(password));
		List<OngEntity> result = getRepository().find(OngEntity.FIND_BY_EMAIL_PASS, params);
		if (result.size() == 1) {
			OngEntity user = result.get(0);
			return user;
		} else {
			throw new IllegalArgumentException("The user or password is wrong");
		}
	}
}

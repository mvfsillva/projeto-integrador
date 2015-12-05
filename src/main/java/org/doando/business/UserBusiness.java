package org.doando.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.doando.entity.UserEntity;
import org.doando.repository.UserRepository;
import org.doando.utils.PasswordUtils;

/**
 *
 * @author yago
 */
public class UserBusiness extends AbstractBusiness<UserEntity, Integer> {

	public UserBusiness() {
		this.repository = new UserRepository();
	}

	@Override
	public int save(UserEntity t) {
		String oldPassword = t.getPassword();
		t.setPassword(PasswordUtils.stringToMD5(oldPassword));
		return super.save(t);
	}

	@Override
	public void update(UserEntity t) {
		String oldPassword = t.getPassword();
		t.setPassword(PasswordUtils.stringToMD5(oldPassword));
		super.update(t);
	}

	public UserEntity tryUserLogin(String username, String password) throws Exception {
		Map<String, Object> params = new HashMap<>();
		String tempUsername = username.toLowerCase().trim();
		params.put("username", tempUsername);
		params.put("password", PasswordUtils.stringToMD5(password));
		List<UserEntity> result = getRepository().find(UserEntity.FIND_BY_EMAIL_AND_PASS, params);
		if (result.size() == 1) {
			UserEntity user = result.get(0);
			return user;
		} else {
			throw new IllegalArgumentException("The user or password is wrong");
		}
	}
}

package org.doando.business;

import org.doando.entity.PersonEntity;
import org.doando.repository.PersonRepository;

/**
 *
 * @author yago
 */
public class PersonBusiness extends AbstractBusiness<PersonEntity, Integer> {

	public PersonBusiness() {
		this.repository = new PersonRepository();
	}
	
	@Override
	public void validate(PersonEntity t) {
		super.validate(t);
		if (t.getName().isEmpty()) {
			throw new IllegalArgumentException("the name is empty");
		}
	}

	public PersonEntity find(String name) {
		return ((PersonRepository) getRepository()).find(name);
	}

}

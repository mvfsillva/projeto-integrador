/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.business;

import com.ads.projetoIntegrador.entity.PersonEntity;
import com.ads.projetoIntegrador.repository.PersonRepository;

/**
 *
 * @author yago
 */
public class PersonBusiness extends AbstractBusinessManager<PersonEntity, Integer> {

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

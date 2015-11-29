package com.ads.projetoIntegrador.appService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IApplicationService<T extends Serializable, IdType extends Serializable> {

	T find(IdType id);

	List<T> find();

	List<T> find(String namedQuery, Map<String, Object> params);

	void save(T t);

	void save(List<T> tList);

	void update(T t);

	void delete(T t);

	void delete(List<T> tList);
}

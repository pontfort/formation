package com.formation.emergency.domain.dao;

import java.util.List;

public interface IRepository<T> {

	void create(Object object) throws Exception;
	
	T read(Object key) throws Exception;
	
	void update(T object) throws Exception;
	
	void delete(Object key) throws Exception;
	
	List<T> findAll() throws Exception;
}

package com.formation.emergency.domain.dao;

import java.util.List;

public interface IRepository<T> {

	public void create(Object object);
	
	public T read(Object key);
	
	public void update(T object) throws Exception;
	
	public void delete(Object key) throws Exception;
	
	public List<T> findAll();
}

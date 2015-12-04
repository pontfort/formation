package com.formation.emergency.domain.dao;

public interface IDao<T>  {
		
	void create(Object item) throws Exception;
	
	T find(Object key) throws Exception;
	
	void update(T item) throws Exception;
	
	void delete(Object key) throws Exception;
	
}

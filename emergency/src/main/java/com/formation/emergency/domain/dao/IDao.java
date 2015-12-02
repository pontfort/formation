package com.formation.emergency.domain.dao;

public interface IDao<T> {

	void create(T item);
	
	T find(Object key);
	
	void update(T item);
	
	void delete(Object key);
	
}

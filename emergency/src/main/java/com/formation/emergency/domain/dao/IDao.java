package com.formation.emergency.domain.dao;

public interface IDao<T> {

	void create(T object);
	
	T read(Object key);
	
	void update(T object);
	
	void delete(Object key);
}
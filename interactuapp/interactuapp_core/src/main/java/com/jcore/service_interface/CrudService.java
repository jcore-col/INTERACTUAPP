package com.jcore.service_interface;

import java.util.List;

public interface CrudService<T> {
	
	void insert(T t) throws Exception;
	void update(T t) throws Exception;
	void delete(T t) throws Exception;
	T findById(T t) throws Exception;
	List<T> findAll() throws Exception;

}

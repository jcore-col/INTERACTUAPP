package com.jcore.repository;
import java.util.List;
public interface JpaRepository<T> {
	void insert(T t) throws Exception;
	void update(T t) throws Exception;
	void delete(T t) throws Exception;
	T findById(T t) throws Exception;
	List<T> findAll() throws Exception;
}

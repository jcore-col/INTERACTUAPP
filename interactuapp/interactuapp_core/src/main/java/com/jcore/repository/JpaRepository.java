package com.jcore.repository;
import java.util.List;
public interface JpaRepository<T> {
	void insert(T t) throws Exception;
	void update(T t) throws Exception;
	void delete(T t) throws Exception;
	List<T> devuelveTodos() throws Exception;
}

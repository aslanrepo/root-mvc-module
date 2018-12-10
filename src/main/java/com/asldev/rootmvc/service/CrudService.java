package com.asldev.rootmvc.service;

import com.asldev.rootmvc.model.BaseEntity;

public interface CrudService<E extends BaseEntity, K> {
	E create(E e);
	E read(K key);
	E update(E e);
	void delete(K key);

	boolean existsById(K key);
}

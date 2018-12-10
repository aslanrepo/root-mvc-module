package com.asldev.rootmvc.rest;

import com.asldev.rootmvc.model.BaseEntity;
import com.asldev.rootmvc.model.dto.BaseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Common Rest Controller
 * @param <E> Entity
 * @param <D> DTO
 * @param <K> Entity Key
 */
@RequestMapping("/api")
public interface RestController<E extends BaseEntity, D extends BaseDTO, K> {
	ResponseEntity<D> get(K id);

	ResponseEntity<D> post(D d);

	ResponseEntity<D> put(K id, D d);

	ResponseEntity<D> delete(K id);

	ResponseEntity<D> patch(K id, D d);
}

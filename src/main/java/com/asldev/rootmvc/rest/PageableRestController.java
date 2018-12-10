package com.asldev.rootmvc.rest;

import com.asldev.rootmvc.config.EntityConfig;
import com.asldev.rootmvc.model.BaseEntity;
import com.asldev.rootmvc.model.dto.BaseDTO;
import com.asldev.rootmvc.service.AbstractPageableService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PageableRestController<E extends BaseEntity, D extends BaseDTO, K> extends AbstractRestController<E, D, K> {

	private final AbstractPageableService<E, K> abstractPageableService;
	protected final EntityConfig entityConfig;

	protected PageableRestController(AbstractPageableService<E, K> abstractPageableService, EntityConfig entityConfig, ModelMapper modelMapper) {
		super(abstractPageableService, modelMapper);
		this.abstractPageableService = abstractPageableService;
		this.entityConfig = entityConfig;
	}

	public ResponseEntity<List<D>> getByPage(int page) {
		List<E> listOfEntity = abstractPageableService.findAll(entityConfig.getPageConfig(page));
		if (listOfEntity.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		List<D> listOfDto = listOfEntity.stream().map(n -> modelMapper.map(n, dtoClass)).collect(Collectors.toList());
		return ResponseEntity.ok(listOfDto);
	}
}
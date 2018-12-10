package com.asldev.rootmvc.config;

import org.springframework.data.domain.Pageable;

public interface EntityConfig {
	Pageable getPageConfig(int page);
}

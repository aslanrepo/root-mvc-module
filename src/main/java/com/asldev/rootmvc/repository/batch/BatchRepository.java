package com.asldev.rootmvc.repository.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

/**
 * This repository is needed to execute batch operations
 */
@Repository
@Transactional
public class BatchRepository implements BatchOperations {
	private final EntityManager em;

	/** default value **/
	@Value("#{${project.settings.jpa.batch-size:100}}")
	private int batchSize;

	@Autowired
	public BatchRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public void batchCreate(Collection<?> collection) {
		int count = 0;
		for (Object entity : collection) {
			em.persist(entity);
			if (batchSize == ++count) {
				em.clear();
				em.flush();
			}
		}
	}

	@Override
	public void batchUpdate(Collection<?> collection) {
		int count = 0;
		for (Object entity : collection) {
			em.merge(entity);
			if (batchSize == ++count) {
				em.clear();
				em.flush();
			}
		}
	}
}

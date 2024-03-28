package com.shopping.product.listeners;

import java.time.LocalDateTime;

import com.shopping.product.entity.BaseEntity;

import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;

public class AuditDateTimeListener {

	@PostUpdate
	private void afterUpdate(BaseEntity entity) {
		entity.setUpdatedDate(LocalDateTime.now());
	}

	@PrePersist
	private void beforePersist(BaseEntity entity) {
		entity.setCreatedDate(LocalDateTime.now());
		entity.setUpdatedDate(LocalDateTime.now());
	}
}

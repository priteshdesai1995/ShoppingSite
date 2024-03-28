package com.shopping.product.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.shopping.product.listeners.AuditDateTimeListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@EntityListeners(AuditDateTimeListener.class)
@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -242255076955431127L;

	@Column(name = "created_date", columnDefinition = "TIMESTAMP")
	protected LocalDateTime createdDate;

	@Column(name = "updated_date", columnDefinition = "TIMESTAMP")
	protected LocalDateTime updatedDate;

}

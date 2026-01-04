package com.consultorio.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class AuditableEntityBase {
    @Column(nullable = true)
    protected Long createdById;
    @Column(nullable = true)
    protected Long updatedById;
    @Column(nullable = true)
    protected LocalDateTime createdAt;
    @Column(nullable = true)
    protected LocalDateTime updatedAt;
}

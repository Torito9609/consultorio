package com.consultorio.domain;

import java.time.LocalDateTime;

public class AuditableEntityBase {
    private Long id;
    protected Long createdById;
    protected Long updatedBuId;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}

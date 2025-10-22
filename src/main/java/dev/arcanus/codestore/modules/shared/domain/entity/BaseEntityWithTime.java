package dev.arcanus.codestore.modules.shared.domain.entity;


import java.time.Instant;

import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;

public abstract class BaseEntityWithTime extends BaseEntity {
    
    private Instant createdAt;
    private Instant updatedAt;

    public BaseEntityWithTime() {
    }

    public BaseEntityWithTime(Id id, Instant createdAt, Instant updatedAt) {
        super(id);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }
}

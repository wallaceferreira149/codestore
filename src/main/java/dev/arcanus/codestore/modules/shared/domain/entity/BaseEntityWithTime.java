package dev.arcanus.codestore.modules.shared.domain.entity;


import java.time.Instant;

import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;

public abstract class BaseEntityWithTime extends BaseEntity {
    
    private Instant createdAt;
    private Instant updatedAt;

    public BaseEntityWithTime() {
    }

    public BaseEntityWithTime(Id id) {
        super(id);
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
    
    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }
}

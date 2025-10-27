package dev.arcanus.codestore.modules.shared.domain.entity;


import java.time.Instant;

public abstract class BaseEntityWithTime extends BaseEntity {
    
    private Instant createdAt;
    private Instant updatedAt;

    public BaseEntityWithTime() {
    }

    public BaseEntityWithTime(Long id) {
        super(id);
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public BaseEntityWithTime(Long id, Instant createdAt, Instant updatedAt) {
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

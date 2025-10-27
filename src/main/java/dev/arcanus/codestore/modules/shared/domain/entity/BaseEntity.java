package dev.arcanus.codestore.modules.shared.domain.entity;

import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;

public abstract class BaseEntity {
    
    private Long id;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package dev.arcanus.codestore.modules.shared.domain.entity;

import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;

public abstract class BaseEntity {
    
    private Id id;

    public BaseEntity() {
    }

    public BaseEntity(Id id) {
        this.id = id;
    }

    public Id getId() {
        return this.id;
    }

    public void setId(Id id) {
        this.id = id;
    }
}

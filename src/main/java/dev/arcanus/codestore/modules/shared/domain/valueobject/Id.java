package dev.arcanus.codestore.modules.shared.domain.valueobject;

public class Id implements ValueObject {
    
    private final Long id;

    public Id(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    
}

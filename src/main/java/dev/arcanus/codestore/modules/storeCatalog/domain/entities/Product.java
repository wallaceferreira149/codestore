package dev.arcanus.codestore.modules.storeCatalog.domain.entities;

import dev.arcanus.codestore.modules.shared.domain.entity.BaseEntity;

public class Product extends BaseEntity {
    private String name;
    private String description;
    private Double salesPrice;

    public Product(){}

    public Product(Long id, String name, String description, Double salesPrice) {
        super(id);
        this.name = name;
        this.description = description;
        this.salesPrice = salesPrice;
    }

    public Product(String name, String description, Double salesPrice) {
        this.name = name;
        this.description = description;
        this.salesPrice = salesPrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

}


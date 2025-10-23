package dev.arcanus.codestore.modules.product_adm.domain.entity;

import dev.arcanus.codestore.modules.shared.domain.entity.AggregateRoot;
import dev.arcanus.codestore.modules.shared.domain.entity.BaseEntityWithTime;
import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;

public class Product extends BaseEntityWithTime implements AggregateRoot{
    
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    public Product() {}

    public Product(Id id, String name, String description, Double price, Integer stock) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}

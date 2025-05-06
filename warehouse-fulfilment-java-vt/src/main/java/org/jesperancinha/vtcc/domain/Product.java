package org.jesperancinha.vtcc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private IsleType isleType;

    public Product() {
        this.id = UUID.randomUUID(); // Default constructor sets a random ID
    }

    public Product(UUID id, String name, IsleType isleType) {
        this.id = id;
        this.name = name;
        this.isleType = isleType;
    }

    // Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IsleType getIsleType() {
        return isleType;
    }

    public void setIsleType(IsleType isleType) {
        this.isleType = isleType;
    }
}

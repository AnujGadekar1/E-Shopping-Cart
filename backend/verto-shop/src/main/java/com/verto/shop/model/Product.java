// PATH: src/main/java/com/verto/shop/model/Product.java
package com.verto.shop.model;

// === NEW: Import JPA annotations ===
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// === NEW: Mark as a database entity ===
@Entity
@Table(name = "products") // Specify the table name
public class Product {

    // === NEW: Mark this as the Primary Key ===
    @Id
    private String id;

    private String name;
    private String description;
    private long priceCents;
    private String imageUrl;
    private String currency;

    public Product() {}

    public Product(String id, String name, String description, long priceCents, String imageUrl, String currency) {
        this.id = id; this.name = name; this.description = description; this.priceCents = priceCents; this.imageUrl = imageUrl; this.currency = currency;
    }

    // ... (All getters and setters remain the same) ...
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public long getPriceCents() { return priceCents; }
    public void setPriceCents(long priceCents) { this.priceCents = priceCents; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
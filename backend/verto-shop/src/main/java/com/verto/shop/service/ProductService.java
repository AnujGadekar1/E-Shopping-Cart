// PATH: src/main/java/com/verto/shop/service/ProductService.java
package com.verto.shop.service;

import com.verto.shop.model.Product;
import com.verto.shop.repository.ProductRepository; // Import the repository
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // Inject the JPA Repository
    private final ProductRepository productRepository;

    @Value("${app.base-url:}")
    private String baseUrl;

    // Constructor-based injection for the repository
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private String buildImageUrl(String path) {
        if (baseUrl == null || baseUrl.isBlank()) return path;
        String trimmed = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        return trimmed + path;
    }

    // Get all products from the database
    public List<Product> getAll() {
        List<Product> products = productRepository.findAll();
        products.forEach(p -> p.setImageUrl(buildImageUrl(p.getImageUrl())));
        return products;
    }

    // Find a single product from the database
    public Optional<Product> findById(String id) {
        Optional<Product> productOpt = productRepository.findById(id);
        productOpt.ifPresent(p -> p.setImageUrl(buildImageUrl(p.getImageUrl())));
        return productOpt;
    }
}
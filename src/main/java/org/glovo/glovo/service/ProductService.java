package org.glovo.glovo.service;

import lombok.AllArgsConstructor;
import org.glovo.glovo.exception.ProductNotFoundException;
import org.glovo.glovo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final List<Product> products;

    public Product getProductById(Long productId) {
        return products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + productId));
    }

    public void addProduct(Product product) {
        product.setId(generateNextProductId());
        products.add(product);
    }

    public void updateProductQuantity(Long productId, int quantity) {
        Product product = getProductById(productId);
        product.setQuantity(quantity);
    }

    private synchronized Long generateNextProductId() {
        return (long) products.size() + 1;
    }
}

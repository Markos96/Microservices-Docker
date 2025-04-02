package org.msvc.product.data.dao;

import org.msvc.product.data.domain.Product;
import org.msvc.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductJPADAO {
    private final ProductRepository productRepository;

    public ProductJPADAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This product by id not exists"));
    }
}

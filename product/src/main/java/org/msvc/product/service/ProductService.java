package org.msvc.product.service;

import org.msvc.product.data.dao.ProductJPADAO;
import org.msvc.product.data.domain.Product;
import org.msvc.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductJPADAO productJPADAO;

    public ProductService(ProductJPADAO productJPADAO) {
        this.productJPADAO = productJPADAO;
    }

    public List<Product> getAllProducts() {
        return productJPADAO.findAll();
    }

    public Product getProductById(Long id) {
        return productJPADAO.findById(id);
    }
}

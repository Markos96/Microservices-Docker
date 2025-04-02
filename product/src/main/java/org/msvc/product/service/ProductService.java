package org.msvc.product.service;

import org.msvc.product.data.dao.ProductJPADAO;
import org.msvc.product.data.domain.Product;
import org.msvc.product.repository.ProductRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductJPADAO productJPADAO;
    private final Environment env;

    public ProductService(ProductJPADAO productJPADAO, Environment environment) {
        this.productJPADAO = productJPADAO;
        this.env = environment;
    }

    public List<Product> getAllProducts() {
        return productJPADAO.findAll()
                .stream().map(product -> {
                    product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                    return product;
                }).toList();
    }

    public Product getProductById(Long id) {
        Product product = productJPADAO.findById(id);
        product.setPort(Integer.parseInt(env.getProperty("local.server.port")));

        return product;
    }
}

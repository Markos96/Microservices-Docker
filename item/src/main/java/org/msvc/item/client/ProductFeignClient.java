package org.msvc.item.client;

import org.msvc.item.data.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product")
public interface ProductFeignClient {

    @GetMapping
    List<Product> findAll();

    @GetMapping("/{id}")
    Product findById(@PathVariable Long id);
}

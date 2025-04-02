package org.msvc.item.service;

import org.msvc.item.client.ProductFeignClient;
import org.msvc.item.data.domain.Item;
import org.msvc.item.data.domain.Product;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class ItemService {

    private final ProductFeignClient productFeignClient;

    public ItemService(ProductFeignClient productFeignClient) {
        this.productFeignClient = productFeignClient;
    }

    public List<Item> findAll() {
        return productFeignClient.findAll()
                .stream()
                .map(product -> new Item(product, new Random().nextInt(10)))
                .toList();
    };

    public Item findById(Long id){
        Product product = productFeignClient.findById(id);
        return new Item(product, new Random().nextInt(10));
    };
}

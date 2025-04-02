package org.msvc.item.service;

import org.msvc.item.data.domain.Item;
import org.msvc.item.data.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Primary
@Service
public class ItemServiceWebClient {
    private final WebClient.Builder webClient;

    public ItemServiceWebClient(WebClient.Builder webClient) {
        this.webClient = webClient;
    }


    public List<Item> findAll() {
        return webClient.build()
                .get()
                .uri("http://product")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Product.class)
                .map(product -> new Item(product, new Random().nextInt(10)))
                .collectList()
                .block();
    };

    public Item findById(Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return this.webClient.build()
                .get()
                .uri("http://product/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Item.class)
                .block();
    };
}

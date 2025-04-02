package org.msvc.item.controller;

import org.msvc.item.data.domain.Item;
import org.msvc.item.service.ItemServiceFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemServiceFeign itemServiceFeign;

    public ItemController(ItemServiceFeign itemServiceFeign) {
        this.itemServiceFeign = itemServiceFeign;
    }

    @GetMapping
    public List<Item> getItems() {
        return this.itemServiceFeign.findAll();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        return this.itemServiceFeign.findById(id);
    }
}

package com.cursor.cursorRestHW.rest;

import com.cursor.cursorRestHW.model.Shop;
import com.cursor.cursorRestHW.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/shops/")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(value = "/shop")
    @ResponseStatus(HttpStatus.CREATED)
    public Shop create(@RequestBody Shop shop) {
        return shopService.create(shop);
    }

    @DeleteMapping(value = "/shop")
    public void delete(@RequestParam Long id) {
        shopService.deleteById(id);
    }

    @GetMapping(value = "/shop")
    public List<Shop> getAll() {
        return shopService.getAll();
    }

    @GetMapping(value = "/shop/{id}")
    public Shop getById(@PathVariable Long id) {
        return shopService.getById(id);
    }

    @PutMapping("/shop/edit/{id}")
    public Shop update(@PathVariable Long id, @RequestBody Shop shop) {
        return shopService.update(id, shop);
    }
}
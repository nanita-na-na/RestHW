package com.cursor.cursorRestHW.service;

import com.cursor.cursorRestHW.model.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {

    Shop create(Shop shop);

    void delete(Long id);

    List<Shop> getAll();

    Shop getById(Long id);

    Shop update(Long id, Shop shop);
}
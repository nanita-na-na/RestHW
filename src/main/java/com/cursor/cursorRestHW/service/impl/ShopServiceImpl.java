package com.cursor.cursorRestHW.service.impl;

import com.cursor.cursorRestHW.exceptions.ShopNotFoundException;
import com.cursor.cursorRestHW.model.Shop;
import com.cursor.cursorRestHW.repository.ShopRepository;
import com.cursor.cursorRestHW.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Shop create(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public void delete(Long id) {

        if (!shopRepository.existsById(id)) {
            throw new ShopNotFoundException();
        }
        shopRepository.deleteById(id);
    }

    @Override
    public List<Shop> getAll() {
        return (List<Shop>) shopRepository.findAll();
    }

    @Override
    public Optional<Shop> getById(Long id) {
        if (!shopRepository.existsById(id)) {
            throw new ShopNotFoundException();
        }
        return shopRepository.findById(id);
    }

    @Override
    public Shop update(Long id, Shop shop) {
        Shop shop1 = shopRepository.findById(id).get();

        shop1.setName(shop.getName());
        shop1.setCity(shop.getCity());
        shop1.setStreet(shop.getStreet());
        shop1.setCountOfEmployees(shop.getCountOfEmployees());
        shop1.setHaveSite(shop.isHaveSite());

        return shopRepository.save(shop1);
    }
}
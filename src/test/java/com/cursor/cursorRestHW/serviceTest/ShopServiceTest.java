package com.cursor.cursorRestHW.serviceTest;

import com.cursor.cursorRestHW.model.Shop;
import com.cursor.cursorRestHW.repository.ShopRepository;
import com.cursor.cursorRestHW.service.impl.ShopServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShopServiceTest {

    private static Shop SHOP = new Shop();

    @Mock
    private ShopRepository shopRepository;

    @InjectMocks
    private ShopServiceImpl shopService;

    @Test
    public void createTest() {
        when(shopRepository.save(SHOP)).thenReturn(SHOP);
        assertEquals(SHOP, shopService.create(SHOP));
    }

    @Test
    public void getAllTest() {
        when(shopRepository.findAll()).thenReturn(List.of(SHOP));
        assertEquals(List.of(SHOP), shopService.getAll());
    }

    @Test
    public void getById() {
       Long shopId = 1L;

       SHOP = new Shop();
       SHOP.setId(shopId);
       SHOP.setName("name");
       SHOP.setCity("city");
       SHOP.setStreet("street");
       SHOP.setHaveSite(true);

       when(shopRepository.findById(shopId)).thenReturn(Optional.of(SHOP));
        Shop byId = shopService.getById(shopId);
        assertEquals(SHOP, byId);
    }

    @Test
    public void updateTest() {
        when(shopRepository.findById(1L)).thenReturn(Optional.of(SHOP));
        when(shopRepository.save(SHOP)).thenReturn(SHOP);
        assertEquals(SHOP, shopService.update(1L, SHOP));
    }
}

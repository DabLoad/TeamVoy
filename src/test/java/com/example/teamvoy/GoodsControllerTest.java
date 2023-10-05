package com.example.teamvoy;

import com.example.teamvoy.dto.GoodsDto;
import com.example.teamvoy.entity.Goods;
import com.example.teamvoy.rest.GoodsController;
import com.example.teamvoy.service.GoodsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
public class GoodsControllerTest {
    @Mock
    private GoodsService goodsService;

    @InjectMocks
    private GoodsController goodsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetGoodsList() {
        when(goodsService.getGoodsList()).thenReturn(new ArrayList<>());

        ResponseEntity<?> response = goodsController.getGoodsList();

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testGetGoods() {
        Long goodsId = 1L;
        when(goodsService.getGoods(goodsId)).thenReturn(new Goods());

        ResponseEntity<?> response = goodsController.getGoods(goodsId);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testCreateGoods() {
        GoodsDto goodsDto = new GoodsDto();
        when(goodsService.addGoods(goodsDto)).thenReturn(new Goods());

        ResponseEntity<?> response = goodsController.createGoods(goodsDto);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testDeleteGoods() {
        Long goodsId = 1L;
        ResponseEntity<?> response = goodsController.deleteGoods(goodsId);

        assertEquals(200, response.getStatusCodeValue());
    }
}

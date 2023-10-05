package com.example.teamvoy;

import com.example.teamvoy.dto.TinyGoodsDto;
import com.example.teamvoy.entity.Order;
import com.example.teamvoy.rest.OrderController;
import com.example.teamvoy.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateOrder() {
        // Arrange
        TinyGoodsDto[] goodsIdMap = new TinyGoodsDto[]{new TinyGoodsDto(), new TinyGoodsDto()};
        Order expectedOrder = new Order();
        when(orderService.createOrder(goodsIdMap)).thenReturn(expectedOrder);

        // Act
        ResponseEntity<?> response = orderController.createOrder(goodsIdMap);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedOrder, response.getBody());
    }

    @Test
    public void testGetOrder() {
        // Arrange
        Long orderId = 1L;
        Order expectedOrder = new Order();
        when(orderService.getOrder(orderId)).thenReturn(expectedOrder);

        // Act
        ResponseEntity<?> response = orderController.getOrder(orderId);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedOrder, response.getBody());
    }

    @Test
    public void testGetOrdersList() {
        // Arrange
        List<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(new Order());
        expectedOrders.add(new Order());
        when(orderService.getOrdersList()).thenReturn(expectedOrders);

        // Act
        ResponseEntity<?> response = orderController.getOrdersList();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedOrders, response.getBody());
    }

    @Test
    public void testPayOrder() {
        // Arrange
        Long orderId = 1L;
        when(orderService.payOrder(orderId)).thenReturn("Order paid");

        // Act
        ResponseEntity<?> response = orderController.payOrder(orderId);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Order paid", response.getBody());
    }
}



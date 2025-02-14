package com.assessment.bistro.repository;

import com.assessment.bistro.model.Order;
import com.assessment.bistro.model.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository repo;


    @BeforeEach
    void setUp() {

    }

    @Test
    public void testGetOrderById() {

        Order orderTestGetById = new Order(4, 14,
                LocalDateTime.of(2021, 11, 15, 0, 0),
                BigDecimal.valueOf(73.00),
                BigDecimal.valueOf(4.20), BigDecimal.valueOf(10.95), BigDecimal.valueOf(88.15));

        Order orderIdFour = repo.getReferenceById(4);

        assertEquals(orderIdFour.toString(), orderTestGetById.toString());
    }

    @Test
    public void testGetAllOrders() {
        int orderTotal = 365;

        int allOrdersTest = repo.findAll().size();

        assertEquals(orderTotal, allOrdersTest);
    }

    @Test
    public void testAddOrder() {
        Order newOrder = new Order(366, 14,
                LocalDateTime.of(2025, 1, 15, 0, 0),
                BigDecimal.valueOf(73.00),
                BigDecimal.valueOf(4.20), BigDecimal.valueOf(10.95), BigDecimal.valueOf(88.15));

        Order addOrder = new Order(366, 14,
                LocalDateTime.of(2025, 1, 15, 0, 0),
                BigDecimal.valueOf(73.00),
                BigDecimal.valueOf(4.20), BigDecimal.valueOf(10.95), BigDecimal.valueOf(88.15));

        Order addedOrder = repo.save(addOrder);

        assertEquals(newOrder.toString(), addedOrder.toString());
        

    }

    @Test
    public void testUpdateOrder() {
        Order updateOrder = new Order(366, 14,
                LocalDateTime.of(2025, 1, 20, 0, 0),
                BigDecimal.valueOf(73.00),
                BigDecimal.valueOf(4.20), BigDecimal.valueOf(10.95), BigDecimal.valueOf(100.00));

        Order order = repo.getReferenceById(366);
        order.setTotal(BigDecimal.valueOf(100.00));
        order.setOrderDate(LocalDateTime.of(2025, 1, 20, 0, 0));
        order = repo.save(order);

        assertEquals(updateOrder, order);
    }

    @Test
    public void testDeleteOrder() {

        repo.delete(repo.getReferenceById(366));

        assertEquals(365, repo.findAll().size());
    }


//    private void compareOrders(Order expected, Order actual) {
//        assertEquals(expected.getOrderId(), actual.getOrderId());
//        assertEquals(expected.getSubTotal(), actual.getSubTotal());
//        assertEquals(expected.getTax(), actual.getTax());
//        assertEquals(expected.getTip(), actual.getTip());
//        assertEquals(expected.getTotal(), actual.getTotal());
//
//        assertEquals(expected.getItems().size(), actual.getItems().size());
//        for (int i = 0; i < expected.getItems().size(); i++) {
//            OrderItem e = expected.getItems().get(i);
//            OrderItem a = actual.getItems().get(i);
//
//            assertEquals(e.getOrderItemId(), a.getOrderItemId());
//            assertEquals(e.getOrderId(), a.getOrderId());
//            assertEquals(e.getItemId(), a.getItemId());
//            assertEquals(e.getQuantity(), a.getQuantity());
//            assertEquals(e.getPrice(), a.getPrice());
//        }

}
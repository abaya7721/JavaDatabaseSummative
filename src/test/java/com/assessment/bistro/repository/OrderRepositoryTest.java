package com.assessment.bistro.repository;

import com.assessment.bistro.model.Order;
import com.assessment.bistro.model.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderRepositoryTest{
    Order orderTestGetById;
    Order newOrder;
    Order updateOrder;


    @Autowired
    private OrderRepository repo;


    @BeforeEach
    void setUp() {
        orderTestGetById = new Order( 14,
                LocalDate.of(2021, 11, 15),
                new BigDecimal("73.00"),
                new BigDecimal("4.20"), new BigDecimal("10.95"), new BigDecimal("88.15"));
        orderTestGetById.setOrderId(4);

        newOrder = new Order(14,
                LocalDate.of(2025, 1, 15),
                new BigDecimal("73.00"),
                new BigDecimal("4.20"), new BigDecimal("10.95"), new BigDecimal("88.15"));
        newOrder.setOrderId(401);

        updateOrder = new Order(18,
                LocalDate.of(2025, 1, 20),
                new BigDecimal("51.00"),
                new BigDecimal("2.93"), new BigDecimal("7.65"), new BigDecimal("100.00"));
        updateOrder.setOrderId(389);
    }

    @Test
    public void testGetOrderById() {

        Optional<Order> orderIdFour = repo.findById(4);

        assertEquals(orderIdFour.get().toString(), orderTestGetById.toString());
    }

    @Test
    public void testGetAllOrders() {
        int orderTotal = 367;

        int allOrdersTest = repo.findAll().size();

        assertEquals(orderTotal, allOrdersTest);
    }

    @Test
    public void testAddOrder() {

        Order addOrder = new Order(14,
                LocalDate.of(2025, 1, 15),
                BigDecimal.valueOf(7300, 2),
                BigDecimal.valueOf(420, 2), BigDecimal.valueOf(1095, 2), BigDecimal.valueOf(8815, 2));
        Order addedOrder = repo.save(addOrder);
        addOrder.setOrderId(401);
        assertEquals(newOrder.toString(), addedOrder.toString());


    }

    @Test
    public void testUpdateOrder() {
        Optional<Order> order = repo.findById(389);

        order.get().setTotal(BigDecimal.valueOf(10000, 2));
        order.get().setOrderDate(LocalDate.of(2025, 1, 20));
        Order orderUpdated = repo.save(order.get());

        assertEquals(updateOrder.toString(), orderUpdated.toString());
    }

    @Test
    public void testDeleteOrder() {

        Optional<Order> orderDelete = repo.findById(403);
        repo.delete(orderDelete.get());

        assertEquals(366, repo.findAll().size());
    }

}
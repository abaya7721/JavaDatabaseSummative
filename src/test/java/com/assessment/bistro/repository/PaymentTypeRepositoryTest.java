package com.assessment.bistro.repository;

import com.assessment.bistro.model.PaymentType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class PaymentTypeRepositoryTest {

    @Autowired
    private PaymentTypeRepository repo;

    @Test
    void testGetAllPaymentTypes() {

        List<PaymentType> bistroDbPaymentTypes = repo.findAll();

        assertEquals(5, bistroDbPaymentTypes.size());
    }
}
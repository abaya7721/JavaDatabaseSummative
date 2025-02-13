package com.assessment.bistro.repository;

import com.assessment.bistro.model.Tax;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaxRepositoryTest {
    Tax expectedRecord1;
    Tax expectedRecord2;

    @Autowired
    TaxRepository repo;

    @BeforeEach
    void setUp() {
        //Tax1
        expectedRecord1 = new Tax();
        expectedRecord1.setTaxId(1);
        expectedRecord1.setTaxPercentage(new BigDecimal("5.75"));
        expectedRecord1.setStartDate(LocalDate.of(2020, 1, 1));
        expectedRecord1.setEndDate(LocalDate.of(2021, 12, 31));

        //Tax2
        expectedRecord2 = new Tax();
        expectedRecord2.setTaxId(2);
        expectedRecord2.setTaxPercentage(new BigDecimal("6.25"));
        expectedRecord2.setStartDate(LocalDate.of(2022, 1, 1));
    }

    @Test
    public void testRecordOneFound() {
        Optional<Tax> taxWithIdOne = repo.findById(1);
        assertEquals(expectedRecord1.toString(), taxWithIdOne.get().toString());
    }

    @Test
    public void testRecordTwoFound() {
        Optional<Tax> taxWithIdTwo = repo.findById(2);
        assertEquals(expectedRecord2.toString(), taxWithIdTwo.get().toString());
    }
}
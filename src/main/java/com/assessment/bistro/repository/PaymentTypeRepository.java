package com.assessment.bistro.repository;

import com.assessment.bistro.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {

}

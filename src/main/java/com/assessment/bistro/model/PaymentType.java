package com.assessment.bistro.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class PaymentType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentTypeId;
    private String paymentTypeName;

    public PaymentType() {
    }

    public PaymentType(int paymentTypeId, String paymentTypeName) {
        this.paymentTypeId = paymentTypeId;
        this.paymentTypeName = paymentTypeName;
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "paymentTypeId=" + paymentTypeId +
                ", paymentTypeName='" + paymentTypeName + '\'' +
                '}';
    }
}

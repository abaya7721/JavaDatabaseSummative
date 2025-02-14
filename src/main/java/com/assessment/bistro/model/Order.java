package com.assessment.bistro.model;


import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;


@Entity
@Table(name="`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int serverId;
    @Temporal(TemporalType.DATE)
    private LocalDate orderDate;
    private BigDecimal subTotal;
    private BigDecimal tax;
    private BigDecimal tip;
    private BigDecimal total;

    public Order(){

    }

    public Order(int serverId, LocalDate orderDate, BigDecimal subTotal, BigDecimal tax, BigDecimal tip, BigDecimal total) {

        this.serverId = serverId;
        this.orderDate = orderDate;
        this.subTotal = subTotal;
        this.tax = tax;
        this.tip = tip;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTip() {
        return tip;
    }

    public void setTip(BigDecimal tip) {
        this.tip = tip;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", serverId=" + serverId +
                ", orderDate=" + orderDate +
                ", subTotal=" + subTotal +
                ", tax=" + tax +
                ", tip=" + tip +
                ", total=" + total +
                '}';
    }

    //    public Collection<Object> getItems() {
//
//    }
}


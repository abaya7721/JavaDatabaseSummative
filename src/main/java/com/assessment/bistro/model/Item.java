package com.assessment.bistro.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private String itemDescription;
    private int itemCategoryId;
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;
    private BigDecimal unitPrice;

    // No-argument constructor
    public Item() {
    }

    // Full-argument constructor except for itemId
    public Item(int itemCategoryId, String itemName, String itemDescription, LocalDate startDate, LocalDate endDate, BigDecimal unitPrice) {
        this.itemCategoryId = itemCategoryId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.unitPrice = unitPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(int itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}

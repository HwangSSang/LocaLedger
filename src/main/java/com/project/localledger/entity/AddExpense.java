package com.project.localledger.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AddExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String expenseType;
    @Column
    private String shopName;
    @Column
    private String itemName;
    @Column
    private int expenseAmount;
    @Column
    private LocalDateTime expenseDate;

    public AddExpense(Long id, String expenseType, String shopName, String itemName, int expenseAmount, LocalDateTime expenseDate) {
        this.id = id;
        this.expenseType = expenseType;
        this.shopName = shopName;
        this.itemName = itemName;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
    }

    public AddExpense() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    @Override
    public String toString() {
        return "AddExpense{" +
                "id=" + id +
                ", expenseType='" + expenseType + '\'' +
                ", shopName='" + shopName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", expenseDate=" + expenseDate +
                '}';
    }
}

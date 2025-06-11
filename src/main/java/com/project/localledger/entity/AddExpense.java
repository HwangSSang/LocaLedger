package com.project.localledger.entity;

import jakarta.persistence.*;

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

    public AddExpense(Long id, String expenseType, String shopName, String itemName, int expenseAmount) {
        this.id = id;
        this.expenseType = expenseType;
        this.shopName = shopName;
        this.itemName = itemName;
        this.expenseAmount = expenseAmount;
    }

    @Override
    public String toString() {
        return "AddExpense{" +
                "id=" + id +
                ", expenseType='" + expenseType + '\'' +
                ", shopName='" + shopName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", expenseAmount=" + expenseAmount +
                '}';
    }
}

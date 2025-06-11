package com.project.localledger.dto;

import com.project.localledger.entity.AddExpense;

public class AddExpenseForm {

    private String expenseType;

    private String shopName;

    private String itemName;

    private int expenseAmount;

    public AddExpenseForm(String expenseType, String shopName, String itemName, int expenseAmount) {
        this.expenseType = expenseType;
        this.shopName = shopName;
        this.itemName = itemName;
        this.expenseAmount = expenseAmount;
    }

    public AddExpenseForm() {

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

    @Override
    public String toString() {
        return "AddExpenseForm{" +
                "expenseType='" + expenseType + '\'' +
                ", shopName='" + shopName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", expenseAmount=" + expenseAmount +
                '}';
    }

    public AddExpense toEntity() {
        return new AddExpense(null, expenseType, shopName, itemName, expenseAmount);
    }
}

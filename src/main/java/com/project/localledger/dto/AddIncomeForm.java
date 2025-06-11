package com.project.localledger.dto;

import com.project.localledger.entity.AddIncome;

public class AddIncomeForm {

    private String incomeContent;
    private int incomeAmount;

    public AddIncomeForm(String incomeContent, int incomeAmount) {
        this.incomeContent = incomeContent;
        this.incomeAmount = incomeAmount;
    }

    public AddIncomeForm() {

    }

    @Override
    public String toString() {
        return "AddIncomeForm{" +
                "incomeContent='" + incomeContent + '\'' +
                ", incomeAmount=" + incomeAmount +
                '}';
    }

    public String getIncomeContent() {
        return incomeContent;
    }

    public void setIncomeContent(String incomeContent) {
        this.incomeContent = incomeContent;
    }

    public int getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(int incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public AddIncome toEntity() {
        return new AddIncome(null, incomeContent, incomeAmount);
    }
}

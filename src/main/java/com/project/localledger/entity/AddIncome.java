package com.project.localledger.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AddIncome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String incomeContent;

    @Column
    private int incomeAmount;

    @Column
    private LocalDateTime incomeDate;

    public AddIncome(Long id, String incomeContent, int incomeAmount, LocalDateTime incomeDate) {
        this.id = id;
        this.incomeContent = incomeContent;
        this.incomeAmount = incomeAmount;
        this.incomeDate = incomeDate;
    }

    public AddIncome() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDateTime incomeDate) {
        this.incomeDate = incomeDate;
    }

    @Override
    public String toString() {
        return "AddIncome{" +
                "id=" + id +
                ", incomeContent='" + incomeContent + '\'' +
                ", incomeAmount=" + incomeAmount +
                ", incomeDate=" + incomeDate +
                '}';
    }
}

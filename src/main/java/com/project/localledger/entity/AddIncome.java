package com.project.localledger.entity;

import jakarta.persistence.*;

@Entity
public class AddIncome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String incomeContent;

    @Column
    private int incomeAmount;

    public AddIncome(Long id, String incomeContent, int incomeAmount) {
        this.id = id;
        this.incomeContent = incomeContent;
        this.incomeAmount = incomeAmount;
    }

    @Override
    public String toString() {
        return "AddIncome{" +
                "id=" + id +
                ", incomeContent='" + incomeContent + '\'' +
                ", incomeAmount=" + incomeAmount +
                '}';
    }


}

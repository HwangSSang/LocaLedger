package com.project.localledger.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

}

package com.project.localledger.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter @AllArgsConstructor
@NoArgsConstructor
@ToString
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

}

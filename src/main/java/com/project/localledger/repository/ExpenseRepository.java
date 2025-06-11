package com.project.localledger.repository;

import com.project.localledger.entity.AddExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<AddExpense, Long> {

    // 지출 일 조회
    @Query("SELECT e FROM AddExpense e WHERE FUNCTION('DATE', e.expenseDate) = :expenseDate")
    List<AddExpense> findByExpenseDate(@org.springframework.data.repository.query.Param("expenseDate") LocalDateTime expenseDate);

    // 지출 월의 지출 내역 조회
    List<AddExpense> findByExpenseDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}

package com.project.localledger.repository;

import com.project.localledger.entity.AddIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface IncomeRepository extends JpaRepository<AddIncome, Long> {

    // 수입 날짜 조회
    @Query("SELECT i FROM AddIncome i WHERE FUNCTION('DATE', i.incomeDate) = :incomeDate")
    List<AddIncome> findByIncomeDate(@org.springframework.data.repository.query.Param("incomeDate") LocalDateTime incomeDate);

    // 특정 월의 수입 날짜 조회
    List<AddIncome> findByIncomeDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}

package com.project.localledger.Controller;

import com.project.localledger.entity.AddExpense;
import com.project.localledger.entity.AddIncome;
import com.project.localledger.repository.ExpenseRepository;
import com.project.localledger.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/ledger")
public class LedgerApiController {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    @Autowired
    public LedgerApiController(IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/monthly")
    @ResponseBody
    public Map<String, List<?>> getMonthlyLedger(
            @RequestParam int year,
            @RequestParam int month){

        LocalDateTime startDate = LocalDate.of(year, month, 1).atStartOfDay(ZoneId.of("Asia/Seoul")).toLocalDateTime();
        LocalDateTime endDate = LocalDate.of(year, month, 1).withDayOfMonth(LocalDate.of(year, month, 1).lengthOfMonth()).atTime(23, 59, 59).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime();

        List<AddIncome> incomes = incomeRepository.findByIncomeDateBetween(startDate, endDate);
        List<AddExpense> expenses = expenseRepository.findByExpenseDateBetween(startDate, endDate);

        Map<String, List<?>> result = new HashMap<>();
        result.put("incomes", incomes);
        result.put("expenses", expenses);
        return result;
    }

    @GetMapping("/daily")
    @ResponseBody
    public Map<String, List<?>> getDailyLedger(
            @RequestParam LocalDate date) {

        LocalDateTime startOfDay = date.atStartOfDay(ZoneId.of("Asia/Seoul")).toLocalDateTime();
        LocalDateTime endOfDay = date.atTime(23, 59, 59).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime();

        List<AddIncome> incomes = incomeRepository.findByIncomeDateBetween(startOfDay, endOfDay);
        List<AddExpense> expenses = expenseRepository.findByExpenseDateBetween(startOfDay, endOfDay);

        Map<String, List<?>> result = new HashMap<>();
        result.put("incomes", incomes);
        result.put("expenses", expenses);
        return result;
    }

}

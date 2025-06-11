package com.project.localledger.dto;

import com.project.localledger.entity.AddIncome;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AddIncomeForm {

    private Long id;
    private String incomeContent;
    private int incomeAmount;
    private String selectedDate;

    public AddIncomeForm(Long id, String incomeContent, int incomeAmount, String selectedDate) {
        this.id = id;
        this.incomeContent = incomeContent;
        this.incomeAmount = incomeAmount;
        this.selectedDate = selectedDate;
    }

    public AddIncomeForm() {

    }

    @Override
    public String toString() {
        return "AddIncomeForm{" +
                "id=" + id +
                ", incomeContent='" + incomeContent + '\'' +
                ", incomeAmount=" + incomeAmount +
                ", selectedDate='" + selectedDate + '\'' +
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public AddIncome toEntity() {
        LocalDateTime recordDate;

        if (this.selectedDate != null && !this.selectedDate.isEmpty()) {
            try {
                // 날짜 문자열 파싱 시도
                LocalDate parsedLocalDate = LocalDate.parse(this.selectedDate, DateTimeFormatter.ISO_LOCAL_DATE);
                recordDate = parsedLocalDate.atStartOfDay(ZoneId.of("Asia/Seoul")).toLocalDateTime();
            } catch (java.time.format.DateTimeParseException e) {
                recordDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
            }
        } else {
            recordDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        }
        return new AddIncome(id, incomeContent, incomeAmount, recordDate);
    }
}

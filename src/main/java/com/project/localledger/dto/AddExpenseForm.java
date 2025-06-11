package com.project.localledger.dto;

import com.project.localledger.entity.AddExpense;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AddExpenseForm {

    private Long id;
    private String expenseType;
    private String shopName;
    private String itemName;
    private int expenseAmount;
    private String selectedDate;

    public AddExpenseForm(Long id, String expenseType, String shopName, String itemName, int expenseAmount, String selectedDate) {
        this.id = id;
        this.expenseType = expenseType;
        this.shopName = shopName;
        this.itemName = itemName;
        this.expenseAmount = expenseAmount;
        this.selectedDate = selectedDate;
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

    @Override
    public String toString() {
        return "AddExpenseForm{" +
                "id=" + id +
                ", expenseType='" + expenseType + '\'' +
                ", shopName='" + shopName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", selectedDate='" + selectedDate + '\'' +
                '}';
    }

    public AddExpense toEntity() {
        LocalDateTime recordDate;
        if (this.selectedDate != null && !this.selectedDate.isEmpty()) {
            try {
                LocalDate parsedLocalDate = LocalDate.parse(this.selectedDate, DateTimeFormatter.ISO_LOCAL_DATE);
                recordDate = parsedLocalDate.atStartOfDay(ZoneId.of("Asia/Seoul")).toLocalDateTime();
            } catch (java.time.format.DateTimeParseException e) {
                System.err.println("ERROR: 지출 selectedDate '" + this.selectedDate + "' 파싱 실패. 현재 날짜 사용. 에러: " + e.getMessage());
                recordDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
            }
        } else {
            recordDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        }
        return new AddExpense(null, expenseType, shopName, itemName, expenseAmount, recordDate);
    }
}

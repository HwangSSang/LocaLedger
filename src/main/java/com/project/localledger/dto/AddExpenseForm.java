package com.project.localledger.dto;

import com.project.localledger.entity.AddExpense;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddExpenseForm {

    private Long id;
    private String expenseType;
    private String shopName;
    private String itemName;
    private int expenseAmount;
    private String selectedDate;


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

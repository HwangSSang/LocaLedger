package com.project.localledger.dto;

import com.project.localledger.entity.AddIncome;
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
public class AddIncomeForm {

    private Long id;
    private String incomeContent;
    private int incomeAmount;
    private String selectedDate;


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

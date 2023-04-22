package com.financier.billy.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class IncomeDTO {

    private BigDecimal amount;

    private LocalDateTime dateTime;
}
package com.financier.billy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Entity
@Table(name = "income", schema = "public")
@AllArgsConstructor
public class Income {

    public Income() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_deleted")
    private boolean deleted;
}
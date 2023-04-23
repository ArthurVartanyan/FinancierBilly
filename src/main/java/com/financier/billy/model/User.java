package com.financier.billy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pg_user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long userId;
}
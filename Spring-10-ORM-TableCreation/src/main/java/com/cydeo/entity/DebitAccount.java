package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
@Entity
@Table(name = "debitaccountable")
public class DebitAccount extends Account{
    private BigDecimal overDraftFee;
}

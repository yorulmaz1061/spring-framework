package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "patmentDetails")
@NoArgsConstructor
@Data
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal commissionAmount;
    private BigDecimal merchantPayoutAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    @OneToOne(mappedBy = "paymentDetail", cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public PaymentDetail(BigDecimal commissionAmount, BigDecimal merchantPayoutAmount, LocalDate payoutDate) {
        this.commissionAmount = commissionAmount;
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.payoutDate = payoutDate;
    }
}

package com.tarif.BookMyShow2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import com.tarif.BookMyShow2.models.enums.PaymentMode;
import com.tarif.BookMyShow2.models.enums.PaymentStatus;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private Long amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private String transactionId;
}

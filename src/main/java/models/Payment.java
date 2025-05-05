package models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import models.enums.PaymentMode;
import models.enums.PaymentStatus;

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

package dev.shubham.paymentservices.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDto {
    private Long OrderId;
    private String name;
    private int amount;
}

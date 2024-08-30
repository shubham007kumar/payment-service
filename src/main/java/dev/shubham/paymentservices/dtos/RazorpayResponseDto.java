package dev.shubham.paymentservices.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RazorpayResponseDto {
    private String id;
    private String entity;
    private int amount;
    private int amount_paid;
    private int amount_due;
    private String currency;
    private String receipt;
    private String offer_id;
    private String status;
    private int attempts;
    private List<String> notes;
    private long created_at;
}

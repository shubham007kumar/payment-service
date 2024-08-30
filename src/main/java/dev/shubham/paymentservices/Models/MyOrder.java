package dev.shubham.paymentservices.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyOrder {
    private String id;
    private int amount;
    private String currency;
    private String status;
}

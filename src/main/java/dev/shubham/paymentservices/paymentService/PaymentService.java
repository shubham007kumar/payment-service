package dev.shubham.paymentservices.paymentService;

import dev.shubham.paymentservices.Models.MyOrder;

public interface PaymentService {
    public MyOrder initiatePayment(Long OrderId, String name, int amount);
}

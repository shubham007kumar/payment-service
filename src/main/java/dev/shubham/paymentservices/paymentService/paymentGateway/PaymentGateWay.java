package dev.shubham.paymentservices.paymentService.paymentGateway;

import dev.shubham.paymentservices.Models.MyOrder;

public interface PaymentGateWay {

    public MyOrder generatePaymentLink(Long OrderId, String name, int amount);

}

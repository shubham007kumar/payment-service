package dev.shubham.paymentservices.paymentService;

import dev.shubham.paymentservices.Models.MyOrder;
import dev.shubham.paymentservices.paymentService.paymentGateway.PaymentGateWay;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImple implements PaymentService{
    private PaymentGateWay paymentGateWay;
    public PaymentServiceImple(@Qualifier("razorpayGateway") PaymentGateWay paymentGateWay){
        this.paymentGateWay = paymentGateWay;
    }
    @Override
    public MyOrder initiatePayment(Long OrderId, String name, int amount) {
        return paymentGateWay.generatePaymentLink(OrderId,name,amount);
    }

}

package dev.shubham.paymentservices.paymentService.paymentGateway;

import dev.shubham.paymentservices.Models.MyOrder;
import org.springframework.stereotype.Service;

@Service("stripeGateway")
public class StripePaymentGateway implements PaymentGateWay{
    @Override
    public MyOrder generatePaymentLink(Long OrderId, String name, int amount) {
        return null;
    }

}

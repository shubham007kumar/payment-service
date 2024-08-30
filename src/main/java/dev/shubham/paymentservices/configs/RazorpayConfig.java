package dev.shubham.paymentservices.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {

    @Value("${RazorpayKey}")
    private String RazorpayKey;

    @Value("${RazorpaySecret}")
    private String RazorpaySecret;

    @Bean
    public RazorpayClient razorpayClient() throws RazorpayException {
        return new RazorpayClient(RazorpayKey,RazorpaySecret);
    }
}

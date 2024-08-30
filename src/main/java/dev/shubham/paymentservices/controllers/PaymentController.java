package dev.shubham.paymentservices.controllers;

import dev.shubham.paymentservices.Models.MyOrder;
import dev.shubham.paymentservices.dtos.PaymentRequestDto;
import dev.shubham.paymentservices.paymentService.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;

@RestController
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/")
    public String welcome(){
        return "hello world";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/payment")
    public ResponseEntity<MyOrder> initiatePayment(@RequestBody PaymentRequestDto paymentRequestDto){
      MyOrder response =  paymentService.initiatePayment(paymentRequestDto.getOrderId(),paymentRequestDto.getName(),paymentRequestDto.getAmount());
      ResponseEntity<MyOrder> result = new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
      return result;
    }

    @PostMapping("/verification")
    public ResponseEntity<String> verifyPayment(@RequestBody Map<String, Object> requestBody, @RequestHeader("x-razorpay-signature") String signature){
       System.out.print(requestBody);
       return ResponseEntity.ok().body("Request is legitimate");
    }

}

package dev.shubham.paymentservices.paymentService.paymentGateway;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import dev.shubham.paymentservices.Models.MyOrder;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpayGateway")
public class RazorpayPaymentGateway implements PaymentGateWay {


   private RazorpayClient razorpayClient;
   public RazorpayPaymentGateway(RazorpayClient razorpayClient){
       this.razorpayClient = razorpayClient;
   }

    @Override
    public MyOrder generatePaymentLink(Long OrderId, String name, int amount) {
        MyOrder result = null;
        try {
//            JSONObject paymentLinkRequest = new JSONObject();
//            paymentLinkRequest.put("amount",1000);
//            paymentLinkRequest.put("currency","INR");
//            paymentLinkRequest.put("accept_partial",true);
//            paymentLinkRequest.put("first_min_partial_amount",100);
//            paymentLinkRequest.put("expire_by",1715432400);
//            paymentLinkRequest.put("reference_id","TS1989");
//            paymentLinkRequest.put("description","Payment for policy no #23456");
//            JSONObject customer = new JSONObject();
//            customer.put("name","+919000090000");
//            customer.put("contact","Gaurav Kumar");
//            customer.put("email","yuvraj.shubham.ss@gmail.com");
//            paymentLinkRequest.put("customer",customer);
//            JSONObject notify = new JSONObject();
//            notify.put("sms",true);
//            notify.put("email",true);
//            paymentLinkRequest.put("notify",notify);
//            paymentLinkRequest.put("reminder_enable",true);
//            JSONObject notes = new JSONObject();
//            notes.put("policy_name","Jeevan Bima");
//            paymentLinkRequest.put("notes",notes);
//            paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
//            paymentLinkRequest.put("callback_method","get");
//
//            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
//            result = payment.toString();
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount",amount);
            orderRequest.put("currency","INR");
            orderRequest.put("receipt", "eceipt#1");
            JSONObject notes = new JSONObject();
            notes.put("notes_key_1","Tea, Earl Grey, Hot");
            notes.put("notes_key_1","Tea, Earl Grey, Hot");
            orderRequest.put("notes",notes);

             Order order = razorpayClient.orders.create(orderRequest);
            MyOrder response = new MyOrder();
             response.setId(order.get("id"));
             response.setAmount(order.get("amount"));
             response.setCurrency(order.get("currency"));
             response.setStatus(order.get("status"));
             result = response;
        }catch (Exception e){
           System.out.print(e.getMessage());
        }
        return result;
    }


}

package com.carterdboyle.store;

import com.carterdboyle.store.services.OrderService;
import com.carterdboyle.store.services.PaymentService;
import com.carterdboyle.store.services.PaypalPaymentService;
import com.carterdboyle.store.services.StripePaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Value("${payment-service}")
    String paymentServiceName;

    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        return new PaypalPaymentService();
    }

    @Bean
    public OrderService orderService() {
        if (paymentServiceName.equals("stripe")) {
            return new OrderService(stripe());
        }

        return new OrderService(paypal());
    }
}

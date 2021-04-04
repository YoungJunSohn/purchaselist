package com.james.purchaselist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PurchaseListApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurchaseListApplication.class, args);
    }

}

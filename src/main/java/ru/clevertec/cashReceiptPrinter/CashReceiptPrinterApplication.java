package ru.clevertec.cashReceiptPrinter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CashReceiptPrinterApplication {

    public static void main(String[] args) {
        System.out.println(1);
        SpringApplication.run(CashReceiptPrinterApplication.class, args);

    }
}

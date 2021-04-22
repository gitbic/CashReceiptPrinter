package ru.clevertec.cashReceiptPrinter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CashReceiptPrinterApplication {

    public static void main(String[] args) {
        System.out.println(1);
        SpringApplication.run(CashReceiptPrinterApplication.class, args);
    }
}

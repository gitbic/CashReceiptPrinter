package ru.clevertec.cashReceiptPrinter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CashReceiptPrinterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CashReceiptPrinterApplication.class, args);
    }
}

package ru.clevertec.cashReceiptPrinter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptService;
import ru.clevertec.cashReceiptPrinter.service.impl.PdfCashReceiptService;
import ru.clevertec.cashReceiptPrinter.service.impl.TxtCashReceiptService;

@Configuration
public class AppConfiguration {

    @Bean(name = "cashReceiptService")
    @CashReceiptType(value = "pdf")
    public CashReceiptService pdfCashReceiptService() {
        return new PdfCashReceiptService();
    }

    @Bean(name = "cashReceiptService")
    @CashReceiptType(value = "txt")
    public CashReceiptService txtCashReceiptService() {
        return new TxtCashReceiptService();
    }
}
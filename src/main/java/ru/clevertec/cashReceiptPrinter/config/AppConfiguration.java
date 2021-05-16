package ru.clevertec.cashReceiptPrinter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.cashReceiptPrinter.enums.CashReceiptType;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptService;
import ru.clevertec.cashReceiptPrinter.service.impl.PdfCashReceiptService;
import ru.clevertec.cashReceiptPrinter.service.impl.TxtCashReceiptService;

@Slf4j
@Configuration
public class AppConfiguration {

    @Bean(name = "cashReceiptService")
    @CashReceiptTypeAnnotation(value = CashReceiptType.PDF)
    public CashReceiptService pdfCashReceiptService() {
        log.info("Initiating pdf cash receipt service bean");
        return new PdfCashReceiptService();
    }

    @Bean(name = "cashReceiptService")
    @CashReceiptTypeAnnotation(value = CashReceiptType.TXT)
    public CashReceiptService txtCashReceiptService() {
        log.info("Initiating txt cash receipt service bean");
        return new TxtCashReceiptService();
    }
}
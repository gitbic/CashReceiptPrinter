package ru.clevertec.cashReceiptPrinter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.cashReceiptPrinter.Dto.OrderDto;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptService;

@Slf4j
@RestController
@RequestMapping("/cashReceipt")
public class CashReceiptController {

    private final CashReceiptService cashReceiptService;

    @Autowired
    public CashReceiptController(CashReceiptService cashReceiptService) {
        this.cashReceiptService = cashReceiptService;

    }

    @PostMapping
    public String printCashReceipt(@RequestBody OrderDto orderDto) {
        log.info("Method: {}, input value: {}", "printCashReceipt", orderDto);

        String cashReceiptUrl = cashReceiptService.printCashReceipt(orderDto);

        log.info("Method: {}, output value: cashReceiptUrl = {}", "printCashReceipt", cashReceiptUrl);
        return cashReceiptUrl;
    }
}

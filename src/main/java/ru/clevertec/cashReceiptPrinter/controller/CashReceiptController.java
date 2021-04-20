package ru.clevertec.cashReceiptPrinter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.cashReceiptPrinter.Dto.OrderDto;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptService;

@RestController
@RequestMapping("/cashReceipt")
public class CashReceiptController {

    CashReceiptService cashReceiptService;

    @PostMapping
    public String printCashReceipt(@RequestBody OrderDto orderDto) {
        return "cashReceiptService.createCashReceipt(orderDto);";
    }
}

package ru.clevertec.cashReceiptPrinter.service;

import org.springframework.stereotype.Service;
import ru.clevertec.cashReceiptPrinter.dto.OrderDto;

import java.io.ByteArrayOutputStream;

@Service
public interface CashReceiptService {

    ByteArrayOutputStream createCashReceipt(OrderDto orderDto);

    String printCashReceipt(OrderDto orderDto);

}

package ru.clevertec.cashReceiptPrinter.service;

import org.springframework.stereotype.Service;
import ru.clevertec.cashReceiptPrinter.Dto.OrderDto;

import java.io.ByteArrayOutputStream;

@Service
public interface CashReceiptService {

    ByteArrayOutputStream createCashReceipt(OrderDto orderDto);

    String printCashReceipt(OrderDto orderDto);

}

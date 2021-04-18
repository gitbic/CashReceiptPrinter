package ru.clevertec.cashReceiptPrinter.service;

import ru.clevertec.cashReceiptPrinter.Dto.OrderDto;

import java.io.ByteArrayOutputStream;

public interface CashReceiptService {

    ByteArrayOutputStream createCashReceipt(OrderDto orderDto);

    String printCashReceipt(ByteArrayOutputStream byteArrayOutputStream);
}

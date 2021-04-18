package ru.clevertec.cashReceiptPrinter.service.impl;

import ru.clevertec.cashReceiptPrinter.Dto.OrderDto;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptService;

import java.io.ByteArrayOutputStream;

public class PdfCashReceiptService implements CashReceiptService {
    @Override
    public ByteArrayOutputStream createCashReceipt(OrderDto orderDto) {
        return null;
    }

    @Override
    public String printCashReceipt(ByteArrayOutputStream byteArrayOutputStream) {
        return null;
    }
}

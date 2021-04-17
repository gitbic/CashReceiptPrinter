package ru.clevertec.cashReceiptPrinter.service;

import ru.clevertec.cashReceiptPrinter.beans.Purchase;

import java.io.ByteArrayOutputStream;
import java.util.List;

public interface CashReceiptCreator {

    ByteArrayOutputStream createCheck(List<Purchase> purchases, String[] tailArgs);

}

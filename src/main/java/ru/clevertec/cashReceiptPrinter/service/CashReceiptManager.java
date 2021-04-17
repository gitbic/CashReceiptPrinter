package ru.clevertec.cashReceiptPrinter.service;



import ru.clevertec.cashReceiptPrinter.beans.Purchase;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public enum CashReceiptManager {

    TXT(new CashReceiptCreatorTxt()) {
        @Override
        public void printCheck() {
            printCheckToFile("check.txt");
        }
    },
    PDF(new CashReceiptCreatorPdf()) {
        @Override
        public void printCheck() {
            printCheckToFile("check.pdf");
        }
    },
    CONSOLE(new CashReceiptCreatorTxt()) {
        @Override
        public void printCheck() {
            System.out.println(byteArrayOutputStream);
        }
    };

    CashReceiptCreator cashReceiptCreator;
    ByteArrayOutputStream byteArrayOutputStream;

    CashReceiptManager(CashReceiptCreator cashReceiptCreator) {
        this.cashReceiptCreator = cashReceiptCreator;
    }

    public void createCheck(List<Purchase> purchases, String[] tailArgs) {
        byteArrayOutputStream = cashReceiptCreator.createCheck(purchases, tailArgs);
    }

    public abstract void printCheck();

    protected void printCheckToFile(String filePath) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            byteArrayOutputStream.writeTo(fileOutputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}

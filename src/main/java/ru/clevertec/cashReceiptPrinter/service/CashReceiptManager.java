package ru.clevertec.cashReceiptPrinter.service;



import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.List;

//public enum CashReceiptManager {
//
//    TXT(new CashReceiptCreatorTxt()) {
//        @Override
//        public void printCheck() {
//            printCheckToFile(Arguments.CHECK_TXT_OUTPUT_PATH_FILE.getValue());
//        }
//    },
//    PDF(new CashReceiptCreatorPdf()) {
//        @Override
//        public void printCheck() {
//            printCheckToFile(Arguments.CHECK_PDF_OUTPUT_PATH_FILE.getValue());
//        }
//    },
//    CONSOLE(new CashReceiptCreatorTxt()) {
//        @Override
//        public void printCheck() {
//            System.out.println(byteArrayOutputStream);
//        }
//    };
//
//    ru.clevertec.checkmanage.CashReceiptCreator cashReceiptCreator;
//    ByteArrayOutputStream byteArrayOutputStream;
//    Publisher publisher = new Publisher(State.PDF_CHECK_PRINTED, State.TXT_CHECK_PRINTED, State.CONSOLE_CHECK_PRINTED);
//
//    CashReceiptManager(ru.clevertec.checkmanage.CashReceiptCreator cashReceiptCreator) {
//        this.cashReceiptCreator = cashReceiptCreator;
//    }
//
//    public void createCheck(List<Purchase> purchases, String[] tailArgs) {
//        byteArrayOutputStream = cashReceiptCreator.createCheck(purchases, tailArgs);
//    }
//
//    public abstract void printCheck();
//
//    protected void printCheckToFile(String filePath) {
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
//            byteArrayOutputStream.writeTo(fileOutputStream);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public Publisher getPublisher() {
//        return publisher;
//    }
//

//}

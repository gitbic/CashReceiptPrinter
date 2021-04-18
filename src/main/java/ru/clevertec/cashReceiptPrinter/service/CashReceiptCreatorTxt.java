package ru.clevertec.cashReceiptPrinter.service;


import ru.clevertec.cashReceiptPrinter.beans.Purchase;
import ru.clevertec.cashReceiptPrinter.constants.Constants;
import ru.clevertec.cashReceiptPrinter.enums.TableMenu;
import ru.clevertec.cashReceiptPrinter.enums.TableTail;

import java.io.ByteArrayOutputStream;
import java.util.Formatter;
import java.util.List;

public class CashReceiptCreatorTxt implements CashReceiptCreator {

    private final static String MENU_DELIMITER = "=".repeat(TableMenu.getTotalWidth()) + System.lineSeparator();

    @Override
    public ByteArrayOutputStream createCheck(List<Purchase> purchases, String[] tailArgs) {
        String str = getCheckHead()
                + MENU_DELIMITER
                + getCheckBody(purchases)
                + MENU_DELIMITER
                + getCheckTail(tailArgs);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.writeBytes(str.getBytes());
        return byteArrayOutputStream;
    }

    private String getCheckHead() {
        Formatter f = new Formatter();
        for (TableMenu value : TableMenu.values()) {
            f.format(value.getFormatForCell(), value);
        }
        f.format(System.lineSeparator());
        return f.toString();
    }

    private String getCheckBody(List<Purchase> purchases) {
        Formatter f = new Formatter();

        for (Purchase purchase : purchases) {
            String[] elements = purchase.toString().split(Constants.CSV_DELIMITER);

            for (int i = 0; i < elements.length; i++) {
                f.format(TableMenu.values()[i].getFormatForCell(), elements[i]);
            }

            f.format(System.lineSeparator());
        }
        return f.toString();
    }

    private String getCheckTail(String[] tailArgs) {
        String tailString = TableTail.getTailFormatString();
        Formatter f = new Formatter();
        f.format(tailString, TableTail.TOTAL, tailArgs[TableTail.TOTAL.ordinal()]);
        f.format(tailString, TableTail.DISCOUNT, tailArgs[TableTail.DISCOUNT.ordinal()]);
        f.format(tailString, TableTail.PAYMENT, tailArgs[TableTail.PAYMENT.ordinal()]);
        return f.toString();
    }
}

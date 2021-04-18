package ru.clevertec.cashReceiptPrinter.enums;


import ru.clevertec.cashReceiptPrinter.constants.Constants;

public enum TableTail {
    TOTAL,
    DISCOUNT,
    PAYMENT;


    public static String getTailFormatString() {
        int secondCellWidth = TableMenu.DISCOUNT.getWidthCell() + TableMenu.TOTAL.getWidthCell();
        int commonWidth = TableMenu.getTotalWidth() - secondCellWidth;

        return String.format(Constants.FORMAT_CELL, commonWidth)
                + String.format(Constants.FORMAT_CELL, secondCellWidth)
                + Constants.FORMAT_NEW_LINE;
    }

    public static float[] getTailCellsWidth() {

        int secondCellWidth = TableMenu.DISCOUNT.getWidthCell() + TableMenu.TOTAL.getWidthCell();
        return new float[]{
                TableMenu.getTotalWidth() - secondCellWidth,
                secondCellWidth
        };
    }
}

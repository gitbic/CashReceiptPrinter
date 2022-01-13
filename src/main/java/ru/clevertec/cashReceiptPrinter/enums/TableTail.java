package ru.clevertec.cashReceiptPrinter.enums;


import ru.clevertec.cashReceiptPrinter.constants.Constants;

public enum TableTail {
    TOTAL,
    DISCOUNT,
    PAYMENT;


    public static String getTailFormatString() {
        float[] cellsWidth = getTailCellsWidth();
        return String.format(Constants.FORMAT_CELL, (int)cellsWidth[0])
                + String.format(Constants.FORMAT_CELL, (int)cellsWidth[1])
                + System.lineSeparator();
    }

    public static float[] getTailCellsWidth() {
        int secondCellWidth = TableMenu.DISCOUNT.getWidthCell() + TableMenu.TOTAL.getWidthCell();
        int firstCellWidth = TableMenu.getTotalWidth() - secondCellWidth;
        return new float[]{firstCellWidth, secondCellWidth};
    }
}

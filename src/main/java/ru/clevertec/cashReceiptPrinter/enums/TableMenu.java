package ru.clevertec.cashReceiptPrinter.enums;


import ru.clevertec.cashReceiptPrinter.constants.Constants;

import java.util.Arrays;

public enum TableMenu {

    QTY(Constants.QUANTITY_CELL_WIDTH),
    DESCRIPTION(Constants.DESCRIPTION_CELL_WIDTH),
    PRICE(Constants.PRICE_CELL_WIDTH),
    TOTAL(Constants.TOTAL_COST_CELL_WIDTH),
    DISCOUNT(Constants.DISCOUNT_PERCENT_COST_CELL_WIDTH);

    private final int widthCell;

    TableMenu(int widthCell) {
        this.widthCell = widthCell;
    }

    public int getWidthCell() {
        return widthCell;
    }

    public String getFormatForCell() {
        return String.format(Constants.FORMAT_CELL, widthCell);
    }

    public static int getTotalWidth() {
        return Arrays.stream(values()).mapToInt(value -> value.widthCell).sum();
    }

    public static float[] getMenuCellsWidth() {

        float[] cellsWidth = new float[values().length];
        for (int i = 0; i < cellsWidth.length; i++) {
            cellsWidth[i] = values()[i].getWidthCell();
        }
        return cellsWidth;
    }

}

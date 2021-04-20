package ru.clevertec.cashReceiptPrinter.constants;

public class Constants {
    public static final String RESOURCES_PATH = "src/main/resources/";
    public static final String CASH_RECEIPT_DIR_PATH = RESOURCES_PATH + "cashReceipt/";
    public static final String PDF_TEMPLATE_FILE_PATH = RESOURCES_PATH + "templates.pdf";

    public static final String FORMAT_CELL = "%%-%ds";
    public static final String STRING_ONE_SPACE = " ";
    public static final String EMPTY_STRING = "";
    public static final String FSTRING_NUMBER_DECIMAL = "%.2f%%";
    public static final int NUMBER_DECIMAL = 2;
    public static final String SIGN_DOLLAR = "$";

    public static final int PDF_DOC_MARGIN_LEFT = 0;
    public static final int PDF_DOC_MARGIN_RIGHT = 0;
    public static final int PDF_DOC_MARGIN_TOP = 150;
    public static final int PDF_DOC_MARGIN_BOTTOM = 0;
    public static final int PDF_TEMPLATE_PAGE_NUMBER = 1;
    public static final int PDF_TEMPLATE_PAGE_COORD_X = 0;
    public static final int PDF_TEMPLATE_PAGE_COORD_Y = 0;

    public static final String UNDERSCORE_LINE = "-";
    public static final String PREFIX_FILE_DAY_TIME_FORMAT = "yyyy.MM.dd_HH.mm.ss_";

    public static final int QUANTITY_PDF_CELL_WIDTH = 5;
    public static final int DESCRIPTION_PDF_CELL_WIDTH = 15;
    public static final int PRICE_PDF_CELL_WIDTH = 10;
    public static final int TOTAL_COST_PDF_CELL_WIDTH = 10;
    public static final int DISCOUNT_PERCENT_COST_PDF_CELL_WIDTH = 10;
}

package ru.clevertec.cashReceiptPrinter.enums;

public enum CashReceiptType {
    CONSOLE(""),
    TXT(".txt"),
    PDF(".pdf");

    CashReceiptType(String extension) {
        this.extension = extension;
    }

    private final String extension;

    public String getExtension() {
        return extension;
    }

    public String getType() {
        return this.toString().toLowerCase();
    }
}

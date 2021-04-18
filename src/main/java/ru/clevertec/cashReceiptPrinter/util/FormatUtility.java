package ru.clevertec.cashReceiptPrinter.util;



import ru.clevertec.cashReceiptPrinter.constants.Constants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public final class FormatUtility {
    public static String priceToString(BigDecimal value) {
        return Constants.SIGN_DOLLAR + value.setScale(Constants.NUMBER_DECIMAL, RoundingMode.HALF_UP).toString();
    }

    public static String percentToString(double value) {
        return String.format(Locale.ENGLISH, Constants.FSTRING_NUMBER_DECIMAL, value);
    }
}
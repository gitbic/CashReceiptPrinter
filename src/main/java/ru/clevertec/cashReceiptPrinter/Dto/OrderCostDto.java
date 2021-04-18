package ru.clevertec.cashReceiptPrinter.Dto;

import lombok.Data;
import ru.clevertec.cashReceiptPrinter.constants.Constants;
import ru.clevertec.cashReceiptPrinter.util.FormatUtility;

import java.lang.invoke.ConstantBootstraps;
import java.math.BigDecimal;

@Data
public class OrderCostDto {
    private BigDecimal totalCost;
    private BigDecimal finalCost;
    private BigDecimal discountCost;
    private double discountPercentByCard;

    public String getTotalCost() {
        return FormatUtility.priceToString(totalCost);
    }

    public String getFinalCost() {
        return FormatUtility.priceToString(finalCost);
    }

    public String getDiscountCost() {
        return FormatUtility.priceToString(discountCost);
    }

    public String getDiscountPercentByCard() {
        return FormatUtility.percentToString(discountPercentByCard);
    }

    @Override
    public String toString() {
        return FormatUtility.priceToString(totalCost) + Constants.CSV_DELIMITER +
                FormatUtility.priceToString(discountCost) + Constants.CSV_DELIMITER +
                FormatUtility.priceToString(finalCost);
    }
}

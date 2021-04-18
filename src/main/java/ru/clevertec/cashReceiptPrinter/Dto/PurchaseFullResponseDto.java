package ru.clevertec.cashReceiptPrinter.Dto;

import lombok.Data;
import ru.clevertec.cashReceiptPrinter.constants.Constants;
import ru.clevertec.cashReceiptPrinter.util.FormatUtility;

import java.math.BigDecimal;

@Data
public class PurchaseFullResponseDto {
    private Long userId;
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private int productNumber;
    private double discountPercent;
    private BigDecimal purchaseCost;

    @Override
    public String toString() {
        return productNumber + Constants.CSV_DELIMITER +
                productName + Constants.CSV_DELIMITER +
                FormatUtility.priceToString(productPrice) + Constants.CSV_DELIMITER +
                FormatUtility.priceToString(purchaseCost) + Constants.CSV_DELIMITER +
                FormatUtility.percentToString(discountPercent);
    }
}

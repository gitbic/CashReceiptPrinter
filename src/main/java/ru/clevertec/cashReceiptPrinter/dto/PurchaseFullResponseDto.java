package ru.clevertec.cashReceiptPrinter.dto;

import lombok.Data;
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

    public String getProductPrice() {
        return FormatUtility.priceToString(productPrice);
    }

    public String getDiscountPercent() {
        return FormatUtility.percentToString(discountPercent);
    }

    public String getPurchaseCost() {
        return FormatUtility.priceToString(purchaseCost);
    }

    public String getProductNumber() {
        return String.valueOf(productNumber);
    }
}

package ru.clevertec.cashReceiptPrinter.dto;

import lombok.Data;
import ru.clevertec.cashReceiptPrinter.util.FormatUtility;

import java.util.List;

@Data
public class OrderDto {
    private List<PurchaseFullResponseDto> purchaseFullResponseDtoList;
    private OrderCostDto orderCostDto;
    private String username;
    private double discountPercentByCard;

    public String getDiscountPercentByCard() {
        return FormatUtility.percentToString(discountPercentByCard);
    }
}

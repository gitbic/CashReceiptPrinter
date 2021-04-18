package ru.clevertec.cashReceiptPrinter.Dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    List<PurchaseFullResponseDto> purchaseFullResponseDtoList;
    OrderCostDto orderCostDto;
}

package ru.clevertec.cashReceiptPrinter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.clevertec.cashReceiptPrinter.Dto.OrderCostDto;
import ru.clevertec.cashReceiptPrinter.Dto.OrderDto;
import ru.clevertec.cashReceiptPrinter.Dto.PurchaseFullResponseDto;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptService;
import ru.clevertec.cashReceiptPrinter.service.impl.PdfCashReceiptService;
import ru.clevertec.cashReceiptPrinter.service.impl.TxtCashReceiptService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CashReceiptPrinterApplication {

    public static void main(String[] args) {
        System.out.println(1111);
        SpringApplication.run(CashReceiptPrinterApplication.class, args);
    }

    @EventListener
    public void onStartListener(ApplicationReadyEvent event) throws IOException {

        PurchaseFullResponseDto purchaseDto1 = new PurchaseFullResponseDto();
        purchaseDto1.setProductName("banana");
        purchaseDto1.setProductPrice(new BigDecimal("1.234"));
        purchaseDto1.setProductNumber(2);
        purchaseDto1.setPurchaseCost(new BigDecimal("2.46"));
        purchaseDto1.setDiscountPercent(0);

        PurchaseFullResponseDto purchaseDto2 = new PurchaseFullResponseDto();
        purchaseDto2.setProductName("lemon");
        purchaseDto2.setProductPrice(new BigDecimal("5"));
        purchaseDto2.setProductNumber(4);
        purchaseDto2.setPurchaseCost(new BigDecimal("18"));
        purchaseDto2.setDiscountPercent(10);

        List<PurchaseFullResponseDto> purchaseFullResponseDtoList = new ArrayList<>();
        purchaseFullResponseDtoList.add(purchaseDto1);
        purchaseFullResponseDtoList.add(purchaseDto2);

        OrderCostDto orderCostDto = new OrderCostDto();
        orderCostDto.setTotalCost(new BigDecimal("20.46"));
        orderCostDto.setDiscountCost(new BigDecimal("2.05"));
        orderCostDto.setFinalCost(new BigDecimal("18.41"));

        OrderDto orderDto = new OrderDto();
        orderDto.setPurchaseFullResponseDtoList(purchaseFullResponseDtoList);
        orderDto.setOrderCostDto(orderCostDto);
        orderDto.setUsername("user1");
        orderDto.setDiscountPercentByCard(10);

        CashReceiptService txtCashReceiptService = new TxtCashReceiptService();
        String txtCheckPath = txtCashReceiptService.printCashReceipt(orderDto);
        System.out.println(txtCheckPath);

        ByteArrayOutputStream cashReceipt = txtCashReceiptService.createCashReceipt(orderDto);
        System.out.println(cashReceipt);

        CashReceiptService pdfCashReceiptService = new PdfCashReceiptService();
        String pdfCheckPath = pdfCashReceiptService.printCashReceipt(orderDto);
        System.out.println(pdfCheckPath);

    }

}

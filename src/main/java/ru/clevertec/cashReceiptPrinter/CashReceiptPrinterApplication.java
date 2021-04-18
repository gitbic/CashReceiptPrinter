package ru.clevertec.cashReceiptPrinter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.clevertec.cashReceiptPrinter.Dto.OrderCostDto;
import ru.clevertec.cashReceiptPrinter.Dto.OrderDto;
import ru.clevertec.cashReceiptPrinter.Dto.PurchaseFullResponseDto;
import ru.clevertec.cashReceiptPrinter.beans.Product;
import ru.clevertec.cashReceiptPrinter.beans.Purchase;
import ru.clevertec.cashReceiptPrinter.constants.Constants;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptCreatorPdf;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptCreatorTxt;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptManager;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptService;
import ru.clevertec.cashReceiptPrinter.service.impl.TxtCashReceiptService;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
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

        Product product1 = new Product(1, "milk", BigDecimal.valueOf(2.04), true);
        Product product2 = new Product(2, "bread", BigDecimal.valueOf(1.17), false);

        List<Purchase> purchases = new ArrayList<>();
        purchases.add(new Purchase(product1, 2));
        purchases.add(new Purchase(product2, 3));

        String[] costBlock = {"totalCost", "discount", "finalCost"};

//		CashReceiptManager console = CashReceiptManager.CONSOLE;
//
//		console.createCheck(purchases, costBlock);
//		console.printCheck();

//		CashReceiptCreatorPdf cashReceiptCreatorPdf = new CashReceiptCreatorPdf();
//		ByteArrayOutputStream byteArrayOutputStream = cashReceiptCreatorPdf.createCheck(purchases, costBlock);
//		FileOutputStream fileOutputStream = new FileOutputStream(Constants.DEFAULT_CHECK_PDF_OUTPUT_FILE_PATH);
//		byteArrayOutputStream.writeTo(fileOutputStream);


//        CashReceiptCreatorTxt cashReceiptCreatorTxt = new CashReceiptCreatorTxt();
//        ByteArrayOutputStream byteArrayOutputStream = cashReceiptCreatorTxt.createCheck(purchases, costBlock);
//        FileOutputStream fileOutputStream = new FileOutputStream(Constants.DEFAULT_CHECK_TXT_OUTPUT_FILE_PATH);
//        byteArrayOutputStream.writeTo(fileOutputStream);
//        byteArrayOutputStream.writeTo(System.out);


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

        CashReceiptService cashReceiptService = new TxtCashReceiptService();
        ByteArrayOutputStream byteArrayOutputStream = cashReceiptService.createCashReceipt(orderDto);
        FileOutputStream fileOutputStream = new FileOutputStream(Constants.DEFAULT_CHECK_TXT_OUTPUT_FILE_PATH);
        byteArrayOutputStream.writeTo(fileOutputStream);
        byteArrayOutputStream.writeTo(System.out);
    }

}

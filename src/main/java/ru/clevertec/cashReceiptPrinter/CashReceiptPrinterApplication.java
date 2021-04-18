package ru.clevertec.cashReceiptPrinter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.clevertec.cashReceiptPrinter.Dto.PurchaseFullResponseDto;
import ru.clevertec.cashReceiptPrinter.beans.Product;
import ru.clevertec.cashReceiptPrinter.beans.Purchase;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptManager;

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
    public void onStartListener(ApplicationReadyEvent event) {

		Product product1 = new Product(1, "milk", BigDecimal.valueOf(2.04), true);
		Product product2 = new Product(2, "bread", BigDecimal.valueOf(1.17), false);

		List<Purchase> purchases = new ArrayList<>();
		purchases.add(new Purchase(product1, 2));
		purchases.add(new Purchase(product2, 3));

		String[]costBlock ={"totalCost", "discount", "finalCost"};

		CashReceiptManager console = CashReceiptManager.CONSOLE;

		console.createCheck(purchases, costBlock);
		console.printCheck();

//        PurchaseFullResponseDto purchaseDto1 = new PurchaseFullResponseDto();
//        purchaseDto1.setProductName("banana");
//        purchaseDto1.setProductPrice(new BigDecimal("1.234"));
//        purchaseDto1.setProductNumber(2);
//        purchaseDto1.setCost(new BigDecimal("2.46"));
//        purchaseDto1.setDiscountPercent(0);
//
//        PurchaseFullResponseDto purchaseDto2 = new PurchaseFullResponseDto();
//        purchaseDto2.setProductName("lemon");
//        purchaseDto2.setProductPrice(new BigDecimal("5"));
//        purchaseDto2.setProductNumber(4);
//        purchaseDto2.setCost(new BigDecimal("18"));
//        purchaseDto2.setDiscountPercent(10);
//
//        List<PurchaseFullResponseDto> purchaseFullResponseDtoList = new ArrayList<>();
//        purchaseFullResponseDtoList.add(purchaseDto1);
//        purchaseFullResponseDtoList.add(purchaseDto2);


    }

}

package ru.clevertec.cashReceiptPrinter.service.impl;

import ru.clevertec.cashReceiptPrinter.Dto.OrderCostDto;
import ru.clevertec.cashReceiptPrinter.Dto.OrderDto;
import ru.clevertec.cashReceiptPrinter.Dto.PurchaseFullResponseDto;
import ru.clevertec.cashReceiptPrinter.beans.Purchase;
import ru.clevertec.cashReceiptPrinter.constants.Constants;
import ru.clevertec.cashReceiptPrinter.enums.TableMenu;
import ru.clevertec.cashReceiptPrinter.enums.TableTail;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptService;

import java.io.ByteArrayOutputStream;
import java.util.Formatter;
import java.util.List;

public class TxtCashReceiptService implements CashReceiptService {

    private final static String MENU_DELIMITER = "=".repeat(TableMenu.getTotalWidth()) + System.lineSeparator();

    @Override
    public String printCashReceipt(ByteArrayOutputStream byteArrayOutputStream) {
        return null;
    }

    @Override
    public ByteArrayOutputStream createCashReceipt(OrderDto orderDto) {
        String str = getCheckHead()
                + MENU_DELIMITER
                + getCheckBody(orderDto.getPurchaseFullResponseDtoList())
                + MENU_DELIMITER
                + getCheckTail(orderDto.getOrderCostDto());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.writeBytes(str.getBytes());
        return byteArrayOutputStream;
    }

    private String getCheckHead() {
        Formatter f = new Formatter();
        for (TableMenu value : TableMenu.values()) {
            f.format(value.getFormatForCell(), value);
        }
        f.format(System.lineSeparator());
        return f.toString();
    }

    private String getCheckBody(List<PurchaseFullResponseDto> purchasesDto) {
        Formatter formatter = new Formatter();

        for (PurchaseFullResponseDto purchase : purchasesDto) {
            String[] elements = purchase.toString().split(Constants.CSV_DELIMITER);

            for (int i = 0; i < elements.length; i++) {
                formatter.format(TableMenu.values()[i].getFormatForCell(), elements[i]);
            }

            formatter.format(Constants.FORMAT_NEW_LINE);
        }
        return formatter.toString();
    }

    private String getCheckTail(OrderCostDto orderCostDto) {
        String tailString = TableTail.getTailFormatString();
        Formatter formatter = new Formatter();
        formatter.format(tailString, TableTail.TOTAL, orderCostDto.getTotalCost());
        formatter.format(tailString, TableTail.DISCOUNT, orderCostDto.getDiscountPercentByCard());
        formatter.format(tailString, TableTail.PAYMENT, orderCostDto.getFinalCost());
        return formatter.toString();
    }
}

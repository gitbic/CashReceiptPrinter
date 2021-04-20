package ru.clevertec.cashReceiptPrinter.service.impl;

import org.springframework.stereotype.Service;
import ru.clevertec.cashReceiptPrinter.Dto.OrderCostDto;
import ru.clevertec.cashReceiptPrinter.Dto.OrderDto;
import ru.clevertec.cashReceiptPrinter.Dto.PurchaseFullResponseDto;
import ru.clevertec.cashReceiptPrinter.constants.Constants;
import ru.clevertec.cashReceiptPrinter.enums.CashReceiptType;
import ru.clevertec.cashReceiptPrinter.enums.OrderDetail;
import ru.clevertec.cashReceiptPrinter.enums.TableMenu;
import ru.clevertec.cashReceiptPrinter.enums.TableTail;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptService;
import ru.clevertec.cashReceiptPrinter.util.IOUtility;

import java.io.ByteArrayOutputStream;
import java.util.Formatter;
import java.util.List;

@Service
public class TxtCashReceiptService implements CashReceiptService {

    @Override
    public String printCashReceipt(OrderDto orderDto) {
        ByteArrayOutputStream byteArrayOutputStream = createCashReceipt(orderDto);
        String fileExtension = CashReceiptType.TXT.getExtension();
        return IOUtility.writeByteStreamToFile(byteArrayOutputStream, fileExtension);
    }

    @Override
    public ByteArrayOutputStream createCashReceipt(OrderDto orderDto) {
        String str = getOrderDetail(orderDto.getUsername(), orderDto.getDiscountPercentByCard())
                + getLineSeparator()
                + getCheckHead()
                + getCheckBody(orderDto.getPurchaseFullResponseDtoList())
                + getLineSeparator()
                + getCheckTail(orderDto.getOrderCostDto());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.writeBytes(str.getBytes());
        return byteArrayOutputStream;
    }

    private String getOrderDetail(String username, String discountPercent) {
        String tailString = TableTail.getTailFormatString();
        Formatter formatter = new Formatter();
        formatter.format(tailString, OrderDetail.DATA, new java.util.Date());
        formatter.format(tailString, OrderDetail.USERNAME, username);
        formatter.format(tailString, OrderDetail.DISCOUNT_BY_CARD, discountPercent);
        return formatter.toString();
    }

    private String getCheckHead() {
        Formatter formatter = new Formatter();

        for (TableMenu value : TableMenu.values()) {
            formatter.format(value.getFormatForCell(), value);
        }

        formatter.format(System.lineSeparator());
        return formatter.toString();
    }

    private String getCheckBody(List<PurchaseFullResponseDto> purchasesDto) {
        Formatter formatter = new Formatter();

        for (PurchaseFullResponseDto purchase : purchasesDto) {

            formatter.format(TableMenu.QTY.getFormatForCell(), purchase.getProductNumber());
            formatter.format(TableMenu.DESCRIPTION.getFormatForCell(), purchase.getProductName());
            formatter.format(TableMenu.PRICE.getFormatForCell(), purchase.getProductPrice());
            formatter.format(TableMenu.TOTAL.getFormatForCell(), purchase.getPurchaseCost());
            formatter.format(TableMenu.DISCOUNT.getFormatForCell(), purchase.getDiscountPercent());

            formatter.format(System.lineSeparator());
        }
        return formatter.toString();
    }

    private String getCheckTail(OrderCostDto orderCostDto) {
        String tailString = TableTail.getTailFormatString();
        Formatter formatter = new Formatter();
        formatter.format(tailString, TableTail.TOTAL, orderCostDto.getTotalCost());
        formatter.format(tailString, TableTail.DISCOUNT, orderCostDto.getDiscountCost());
        formatter.format(tailString, TableTail.PAYMENT, orderCostDto.getFinalCost());
        return formatter.toString();
    }

    private String getLineSeparator() {
        return Constants.UNDERSCORE_LINE.repeat(TableMenu.getTotalWidth()) + System.lineSeparator();
    }
}

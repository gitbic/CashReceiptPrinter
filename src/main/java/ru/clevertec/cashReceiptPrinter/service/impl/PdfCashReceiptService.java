package ru.clevertec.cashReceiptPrinter.service.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfCashReceiptService implements CashReceiptService {

    @Override
    public String printCashReceipt(OrderDto orderDto) {
        ByteArrayOutputStream byteArrayOutputStream = createCashReceipt(orderDto);
        String fileExtension = CashReceiptType.PDF.getExtension();
        return IOUtility.writeByteStreamToFile(byteArrayOutputStream, fileExtension);
    }

    @Override
    public ByteArrayOutputStream createCashReceipt(OrderDto orderDto) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            Document document = new Document();


            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            document.open();

            document.setMargins(Constants.PDF_DOC_MARGIN_LEFT,
                    Constants.PDF_DOC_MARGIN_RIGHT,
                    Constants.PDF_DOC_MARGIN_TOP,
                    Constants.PDF_DOC_MARGIN_BOTTOM);

            document.newPage();
            useTemplate(writer, Constants.PDF_TEMPLATE_FILE_PATH);

            document.add(getOrderDetail(orderDto.getUsername(), orderDto.getDiscountPercentByCard()));
            document.add(getLineSeparator());
            document.add(getCheckHead());
            document.add(getCheckBody(orderDto.getPurchaseFullResponseDtoList()));
            document.add(getLineSeparator());
            document.add(getCheckTail(orderDto.getOrderCostDto()));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputStream;
    }

    private PdfPTable getOrderDetail(String username, String discountPercent) {
        PdfPTable table = getPdfTable(TableTail.getTailCellsWidth());

        table.addCell(OrderDetail.DATA.toString());
        table.addCell(String.valueOf(new java.util.Date()));
        table.addCell(OrderDetail.USERNAME.toString());
        table.addCell(username);
        table.addCell(OrderDetail.DISCOUNT_BY_CARD.toString());
        table.addCell(discountPercent);

        return table;
    }

    private PdfPTable getCheckHead() {
        PdfPTable table = getPdfTable(TableMenu.getMenuCellsWidth());
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        for (TableMenu value : TableMenu.values()) {
            table.addCell(value.toString());
        }
        return table;
    }

    private PdfPTable getCheckBody(List<PurchaseFullResponseDto> purchasesDto) {
        PdfPTable table = getPdfTable(TableMenu.getMenuCellsWidth());
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        for (PurchaseFullResponseDto purchase : purchasesDto) {
            table.addCell(purchase.getProductNumber());
            table.addCell(purchase.getProductName());
            table.addCell(purchase.getProductPrice());
            table.addCell(purchase.getPurchaseCost());
            table.addCell(purchase.getDiscountPercent());
        }

        return table;
    }

    private PdfPTable getCheckTail(OrderCostDto orderCostDto) {
        PdfPTable table = getPdfTable(TableTail.getTailCellsWidth());

        table.addCell(TableTail.TOTAL.toString());
        table.addCell(orderCostDto.getTotalCost());
        table.addCell(TableTail.DISCOUNT.toString());
        table.addCell(orderCostDto.getDiscountCost());
        table.addCell(TableTail.PAYMENT.toString());
        table.addCell(orderCostDto.getFinalCost());

        return table;
    }

    private void useTemplate(PdfWriter writer, String templateFileName) throws IOException {
        FileInputStream template = new FileInputStream(templateFileName);
        PdfReader reader = new PdfReader(template);
        PdfImportedPage page = writer.getImportedPage(reader, Constants.PDF_TEMPLATE_PAGE_NUMBER);
        PdfContentByte cb = writer.getDirectContent();
        cb.addTemplate(page, Constants.PDF_TEMPLATE_PAGE_COORD_X, Constants.PDF_TEMPLATE_PAGE_COORD_Y);
    }


    private PdfPTable getPdfTable(float[] cellsWidth) {
        PdfPTable table = new PdfPTable(cellsWidth.length);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        try {
            table.setTotalWidth(cellsWidth);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return table;
    }


    private PdfPTable getLineSeparator() {
        PdfPTable table = getPdfTable(TableMenu.getMenuCellsWidth());
        table.getDefaultCell().setBorder(Rectangle.BOTTOM);

        for (int i = 0; i < TableMenu.values().length; i++) {
            table.addCell(Constants.STRING_ONE_SPACE);
        }

        return table;
    }
}

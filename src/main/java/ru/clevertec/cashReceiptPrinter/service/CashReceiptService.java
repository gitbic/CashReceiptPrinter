package ru.clevertec.cashReceiptPrinter.service;

import ru.clevertec.cashReceiptPrinter.Dto.OrderDto;
import ru.clevertec.cashReceiptPrinter.constants.Constants;
import ru.clevertec.cashReceiptPrinter.enums.CashReceiptType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface CashReceiptService {

    ByteArrayOutputStream createCashReceipt(OrderDto orderDto);

    String getExtension();

    default String printCashReceipt(ByteArrayOutputStream byteArrayOutputStream) {

        DateFormat dateFormat = new SimpleDateFormat(Constants.PREFIX_FILE_DAY_TIME_FORMAT);
        String prefix = dateFormat.format(new Date());
        String filePath = Constants.EMPTY_STRING;
        String suffix = getExtension();

        try {
            File file = File.createTempFile(prefix, suffix, new File(Constants.CASH_RECEIPT_FOLDER));
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());

            fileOutputStream.close();
            filePath = file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}

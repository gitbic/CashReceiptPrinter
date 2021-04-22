package ru.clevertec.cashReceiptPrinter.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.clevertec.cashReceiptPrinter.dto.OrderDto;
import ru.clevertec.cashReceiptPrinter.constants.Constants;
import ru.clevertec.cashReceiptPrinter.service.CashReceiptService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public abstract class AbstractCashReceiptService implements CashReceiptService {


    @Override
    public String printCashReceipt(OrderDto orderDto) {
        log.info("Method: {}, input value: {}", "printCashReceipt", orderDto);

        ByteArrayOutputStream byteArrayOutputStream = createCashReceipt(orderDto);
        String fileExtension = getFileExtension();

        DateFormat dateFormat = new SimpleDateFormat(Constants.PREFIX_FILE_DAY_TIME_FORMAT);
        String prefix = dateFormat.format(new Date());
        String cashReceiptUrl = Constants.EMPTY_STRING;

        try {
            File file = File.createTempFile(prefix, fileExtension, new File(Constants.CASH_RECEIPT_DIR_PATH));
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());

            fileOutputStream.close();
            cashReceiptUrl = file.getAbsolutePath();

        } catch (IOException e) {
            log.warn("Method: {}, IOException {}", "printCashReceipt", e.getMessage());
            e.printStackTrace();
        }

        log.info("Method: {}, output value: cashReceiptUrl = {}", "printCashReceipt", cashReceiptUrl);
        return cashReceiptUrl;
    }

    abstract protected String getFileExtension();

}

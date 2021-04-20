package ru.clevertec.cashReceiptPrinter.util;

import ru.clevertec.cashReceiptPrinter.constants.Constants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOUtility {
    public static String writeByteStreamToFile(ByteArrayOutputStream byteArrayOutputStream, String fileExtension) {
        DateFormat dateFormat = new SimpleDateFormat(Constants.PREFIX_FILE_DAY_TIME_FORMAT);
        String prefix = dateFormat.format(new Date());
        String filePath = Constants.EMPTY_STRING;

        try {
            File file = File.createTempFile(prefix, fileExtension, new File(Constants.CASH_RECEIPT_FOLDER));
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

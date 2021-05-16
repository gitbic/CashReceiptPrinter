package ru.clevertec.cashReceiptPrinter.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import ru.clevertec.cashReceiptPrinter.enums.CashReceiptType;

import java.util.Map;
import java.util.ResourceBundle;

public class CashReceiptTypeCondition implements Condition {
    private static final String FIELD_NAME = "value";
//    private static final String PROPERTIES_FILE_NAME = "application";
    private static final String OPTION_KEY_NAME = "cash-receipt.type";
    public static final String DEFAULT_CASH_RECEIPT_TYPE = "pdf";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(CashReceiptTypeAnnotation.class.getName());
//        String type = (String) attributes.get(FIELD_NAME);
        CashReceiptType annotationCashReceiptType = (CashReceiptType)attributes.get(FIELD_NAME);

//        ResourceBundle rb = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);
//        String propertyCashReceiptType = rb.getString(OPTION_KEY_NAME);
        String propertyCashReceiptType = "pdf";

        return propertyCashReceiptType.equals(annotationCashReceiptType.getType());
    }
}

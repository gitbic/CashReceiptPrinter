package ru.clevertec.cashReceiptPrinter.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.ResourceBundle;

public class CashReceiptTypeCondition implements Condition {
    private static final String FIELD_NAME = "value";
    private static final String PROPERTIES_FILE_NAME = "application";
    private static final String OPTION_KEY_NAME = "cash-receipt.type";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(CashReceiptType.class.getName());
        String type = (String) attributes.get(FIELD_NAME);

        ResourceBundle rb = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);
        String cashReceiptType = rb.getString(OPTION_KEY_NAME);

        return cashReceiptType.equalsIgnoreCase(type);
    }
}

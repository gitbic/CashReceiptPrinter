package ru.clevertec.cashReceiptPrinter.config;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Conditional(CashReceiptTypeCondition.class)
public @interface CashReceiptType {
    String value();
}

package ru.clevertec.cashReceiptPrinter.beans;


import java.math.BigDecimal;

public final class Product implements Comparable<Product> {
    private final int id;
    private final String name;
    private final BigDecimal price;
    private final boolean discountForQuantity;

    public Product(int id, String name, BigDecimal price, boolean isDiscountForQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountForQuantity = isDiscountForQuantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isDiscountForQuantity() {
        return discountForQuantity;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int compareTo(Product o) {
        return this.id - o.id;
    }

    public String printToString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isDiscountForQuantity=" + discountForQuantity +
                '}';
    }
}

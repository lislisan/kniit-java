package org.kniit.lab5.task_8;

import java.util.Objects;

public class ShopItem {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public ShopItem(String name) {
        this.name = name;
        this.price = 0.0;
        this.quantity = 0;
        this.category = "default";
    }

    public ShopItem(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("Товарная позиция {name='%s', price=%.2f, quantity=%d, category='%s'}",
                name, price, quantity, category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopItem shopItem = (ShopItem) o;
        return Double.compare(shopItem.price, price) == 0 &&
                quantity == shopItem.quantity &&
                Objects.equals(name, shopItem.name) &&
                Objects.equals(category, shopItem.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity, category);
    }
}
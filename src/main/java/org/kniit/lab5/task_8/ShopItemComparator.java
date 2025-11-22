package org.kniit.lab5.task_8;

import java.util.Comparator;

public class ShopItemComparator implements Comparator<ShopItem> {

    @Override
    public int compare(ShopItem item1, ShopItem item2) {
        int nameComparison = item1.getName().compareTo(item2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        int priceComparison = Double.compare(item1.getPrice(), item2.getPrice());
        if (priceComparison != 0) {
            return priceComparison;
        }
        int quantityComparison = Integer.compare(item1.getQuantity(), item2.getQuantity());
        if (quantityComparison != 0) {
            return quantityComparison;
        }
        return item1.getCategory().compareTo(item2.getCategory());
    }
}
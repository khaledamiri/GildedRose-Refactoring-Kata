package com.gildedrose;

public abstract class AbstractGildedRoseItem implements GildedRoseItemFactory {
    boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    void incrementQuality(Item item) {
        // The Quality of an item is never more than 50
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    void decreaseQuality(Item item) {
        // The Quality of an item is never negative
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    void decrementSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}

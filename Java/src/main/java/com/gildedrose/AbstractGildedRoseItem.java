package com.gildedrose;

public abstract class AbstractGildedRoseItem {
    boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    void decrementSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}

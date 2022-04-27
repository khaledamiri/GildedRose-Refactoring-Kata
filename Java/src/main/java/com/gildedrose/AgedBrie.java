package com.gildedrose;

public class AgedBrie extends AbstractGildedRoseItem {
    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        incrementQuality(item);

        decrementSellIn(item);

        if (hasExpired(item)) {
            incrementQuality(item);
        }
    }
}

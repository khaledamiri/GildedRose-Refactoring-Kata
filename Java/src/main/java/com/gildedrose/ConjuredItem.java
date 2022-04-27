package com.gildedrose;

public class ConjuredItem extends AbstractGildedRoseItem {
    private final Item item;

    public ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        decreaseQuality(item);
        decreaseQuality(item);

        decrementSellIn(item);

        if (hasExpired(item)) {
            decreaseQuality(item);
            decreaseQuality(item);
        }
    }
}

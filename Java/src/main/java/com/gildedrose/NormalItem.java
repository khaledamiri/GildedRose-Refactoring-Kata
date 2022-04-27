package com.gildedrose;

public class NormalItem extends AbstractGildedRoseItem {
    private final Item item;

    public NormalItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        decreaseQuality(item);

        decrementSellIn(item);

        if (hasExpired(item)) {
            decreaseQuality(item);
        }
    }
}

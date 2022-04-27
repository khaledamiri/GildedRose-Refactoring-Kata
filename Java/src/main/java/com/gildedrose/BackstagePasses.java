package com.gildedrose;

public class BackstagePasses extends AbstractGildedRoseItem {
    private final Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        if (item.quality < 50) {
            // First increment
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                // 2nd increment
                incrementQuality(item);
            }

            if (item.sellIn < 6) {
                // 3rd increment
                incrementQuality(item);
            }
        }

        decrementSellIn(item);

        if (hasExpired(item)) {
            item.quality = 0;
        }
    }

}

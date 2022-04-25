package com.gildedrose;

class GildedRose extends AbstractGildedRoseItem {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured Mana Cake";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS)) {
                        decreaseQuality(item);
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.sellIn < 11) {
                            incrementQuality(item);
                        }

                        if (item.sellIn < 6) {
                            incrementQuality(item);
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                decrementSellIn(item);
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS)) {
                                decreaseQuality(item);
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    incrementQuality(item);
                }
            }
        }
    }
}

package com.gildedrose;

import static com.gildedrose.GildedRoseItemFactory.createGildedRoseItem;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of";
    public static final String BACKSTAGE_PASSES = "Backstage passes to";
    public static final String CONJURED = "Conjured";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            createGildedRoseItem(item).updateQuality();
        }
    }
}

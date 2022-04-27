package com.gildedrose;

public interface GildedRoseItemFactory {

    static GildedRoseItemFactory createGildedRoseItem(Item item) {
        if (item.name.startsWith(GildedRose.AGED_BRIE)) {
            return new AgedBrie(item);
        }
        if (item.name.startsWith(GildedRose.BACKSTAGE_PASSES)) {
            return new BackstagePasses(item);
        }
        if (item.name.startsWith(GildedRose.SULFURAS)) {
            return new Sulfuras(item);
        }
//        if (item.name.startsWith(GildedRose.CONJURED)) {
//            return new ConjuredItem(item);
//        }
        return new NormalItem(item);
    }

    void updateQuality();
}

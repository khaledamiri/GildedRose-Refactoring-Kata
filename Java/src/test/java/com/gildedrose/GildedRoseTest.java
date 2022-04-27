package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void qualityIncreasesOverTimeForAgedBrie() {
        // GIVEN
        Item item = new Item("Aged Brie", 12, 3);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        //WHEN
        gildedRose.updateQuality();
        //THEN
        assertEquals(4, item.quality);
        gildedRose.updateQuality();
        assertEquals(5, item.quality);
        gildedRose.updateQuality();
        assertEquals(6, item.quality);
        gildedRose.updateQuality();
        assertEquals(7, item.quality);
        gildedRose.updateQuality();
        assertEquals(8, item.quality);
        gildedRose.updateQuality();
        assertEquals(9, item.quality);
    }

    @Test
    public void qualityIncreasesTwiceWhenSellOutForAgedBrie() {
        // GIVEN
        Item item = new Item("Aged Brie", 0, 3);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(5, item.quality);
        gildedRose.updateQuality();
        assertEquals(7, item.quality);

    }

//    @Test
//    public void qualityDecreasesOverTimeForConjured() {
//        Item item = new Item("Conjured Milk", 5, 5);
//        GildedRose gildedRose = new GildedRose(new Item[]{item});
//        gildedRose.updateQuality();
//
//        assertEquals(4, gildedRose.items[0].sellIn);
//        assertEquals(3, gildedRose.items[0].quality);
//    }

//    @Test
//    public void qualityDecreasesOverTimeTwiceForConjuredAfterExpiring() {
//        Item item = new Item("Conjured Milk", 0, 5);
//        GildedRose gildedRose = new GildedRose(new Item[]{item});
//        gildedRose.updateQuality();
//
//        assertEquals(-1, gildedRose.items[0].sellIn);
//        assertEquals(1, gildedRose.items[0].quality);
//    }

    @Test
    public void qualityDecreasesMoreQuicklyAfterSellByDateForUnknownThings() {
        Item item = new Item("foo", 1, 6);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(5, item.quality);
        gildedRose.updateQuality();
        assertEquals(3, item.quality);
        gildedRose.updateQuality();
        assertEquals(1, item.quality);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void qualityDecreasesAfterSellByDateForUnknownThingsButNeverNegative() {
        Item item = new Item("foo", 1, 6);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(5, item.quality);
        gildedRose.updateQuality();
        assertEquals(3, item.quality);
        gildedRose.updateQuality();
        assertEquals(1, item.quality);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void qualityDecreasesOverTimeForUnknownThings() {
        Item item = new Item("foo", 2, 3);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(2, item.quality);
        gildedRose.updateQuality();
        assertEquals(1, item.quality);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void sellInDecreasesEveryDayForUnknownItem() {
        Item item = new Item("foo", 2, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(1, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(0, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void sellInDecreasesEveryDayForConjuredItem() {
        Item item = new Item("Conjured Milk", 2, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(1, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(0, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void sellInDecreasesEveryDayForAgedBrieItem() {
        Item item = new Item("Aged Brie", 2, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(1, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(0, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void sellInDecreasesEveryDayForBackstageItem() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(1, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(0, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void sulfurasNeverAges() {
        Item item = new Item(GildedRose.SULFURAS, 2, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(2, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(2, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(2, item.sellIn);
    }

}

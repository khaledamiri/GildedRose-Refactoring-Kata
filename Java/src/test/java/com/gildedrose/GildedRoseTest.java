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
        Item item = new Item(GildedRose.AGED_BRIE, 12, 3);
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
    }

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
    public void sellInDecreasesEveryDayForMostItems() {
        sellInDecreasesEveryDayForItem(new Item("foo", 2, 0));
        sellInDecreasesEveryDayForItem(new Item(GildedRose.BACKSTAGE_PASSES, 2, 0));
        sellInDecreasesEveryDayForItem(new Item(GildedRose.AGED_BRIE, 2, 0));
        sellInDecreasesEveryDayForItem(new Item(GildedRose.CONJURED, 2, 0));
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

    private void sellInDecreasesEveryDayForItem(Item item) {
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertEquals(1, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(0, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(-1, item.sellIn);
    }

}

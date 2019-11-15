package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void default_product_without_quality_at_sellIng_day() {
        Item item = new Item("foo", 0, 0);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertAll(
                () ->  assertEquals(-1, item.sellIn, "sellIn"),
                () ->  assertEquals(0, item.quality, "quality")
                );
    }

    @Test
    public void default_product_before__sellIn_quality_lowered_by_one() {
        Item item = new Item("foo", 1, 2);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertAll(
                () ->  assertEquals(0, item.sellIn, "sellIn"),
                () ->  assertEquals(1, item.quality, "quality")
        );
    }
}

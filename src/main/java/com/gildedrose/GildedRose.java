package com.gildedrose;

class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case SULFURAS:
                    break;
                case AGED_BRIE:
                    updateAgedBrie(item);
                    break;
                case BACKSTAGE:
                    updateBackstage(item);
                    break;
                default:
                    updateDefault(item);
                    break;
            }
        }
    }

    private void updateDefault(Item item) {
        decreaseQuality(item);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void updateBackstage(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 10) {
            increaseQuality(item);
        }

        if (item.sellIn <= 5) {
            increaseQuality(item);
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }
}
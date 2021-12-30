package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseBAgedBrieMyTryTest {

	public static final String AGED_BRIE = "Aged Brie";
	public static final int NOT_EXPIRED_SELL_IN = 4;
	public static final int EXPIRED_SELL_IN = -1;

	@Test
	public void shouldIncreaseQualityByOneForNotExpiredSellIn() {
		int quality = 3;
		GildedRose app = getGildedRose(AGED_BRIE, NOT_EXPIRED_SELL_IN, quality);

		app.updateQuality();

		Item actualItem = app.items.get(0);
		Item expectedItem = new Item(AGED_BRIE, NOT_EXPIRED_SELL_IN-1, quality+1);
		assertItem(expectedItem, actualItem);
	}

	@Test
	public void shouldIncreaseQualityByTwoForExpiredSellIn() {
		int quality = 3;
		GildedRose app = getGildedRose(AGED_BRIE, EXPIRED_SELL_IN, quality);

		app.updateQuality();

		Item actualItem = app.items.get(0);
		Item expectedItem = new Item(AGED_BRIE, EXPIRED_SELL_IN-1, quality+2);
		assertItem(expectedItem, actualItem);
	}

	@Test
	public void shouldNotChangeQualityForNotExpiredSellInWithQualityGreaterThan49() {
		int quality = 50;
		GildedRose app = getGildedRose(AGED_BRIE, NOT_EXPIRED_SELL_IN, quality);

		app.updateQuality();

		Item actualItem = app.items.get(0);
		Item expectedItem = new Item(AGED_BRIE, NOT_EXPIRED_SELL_IN-1, quality);
		assertItem(expectedItem, actualItem);
	}

	private GildedRose getGildedRose(String itemName, int sellIn, int quality) {
		List<Item> items = new ArrayList<>();
		items.add(new Item(itemName, sellIn, quality));
		return new GildedRose(items);
	}

	private void assertItem(Item expectedItem, Item actualItem) {
		assertEquals(expectedItem.getName(), actualItem.getName());
		assertEquals(expectedItem.getSellIn(), actualItem.getSellIn());
		assertEquals(expectedItem.getQuality(), actualItem.getQuality());
	}

}

package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseCBackstagePassesMyTryTest {

	public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final int QUALITY = 3;

	@Test
	public void shouldIncreaseQualityByOneForSellInGreaterThan10() { //sellIn = 15 quality  increases by 1
		int sellIn = 15;
		GildedRose app = getGildedRose(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn, QUALITY);

		app.updateQuality();

		Item actualItem = app.items.get(0);
		Item expectedItem = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn - 1, QUALITY + 1);
		assertItem(expectedItem, actualItem);
	}

	@Test
	public void shouldIncreaseQualityByTwoForSellInBetween5And10() { // sellIn = 7 quality increases by 2
		int sellIn = 7;
		GildedRose app = getGildedRose(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn, QUALITY);

		app.updateQuality();

		Item actualItem = app.items.get(0);
		Item expectedItem = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn - 1, QUALITY + 2);

		assertItem(expectedItem, actualItem);
	}

	@Test
	public void shouldIncreaseQualityByThreeForSellInLessThan6() { // sellIn = 4 quality increases by 3
		int sellIn = 4;
		GildedRose app = getGildedRose(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn, QUALITY);

		app.updateQuality();

		Item actualItem = app.items.get(0);
		Item expectedItem = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn - 1, QUALITY + 3);
		assertItem(expectedItem, actualItem);
	}

	private void assertItem(Item expectedItem, Item actualItem) {
		assertEquals(expectedItem.getName(), actualItem.getName());
		assertEquals(expectedItem.getSellIn(), actualItem.getSellIn());
		assertEquals(expectedItem.getQuality(), actualItem.getQuality());
	}

	private GildedRose getGildedRose(String itemName, int sellIn, int quality) {
		List<Item> items = new ArrayList<>();
		items.add(new Item(itemName, sellIn, quality));
		return new GildedRose(items);
	}

}
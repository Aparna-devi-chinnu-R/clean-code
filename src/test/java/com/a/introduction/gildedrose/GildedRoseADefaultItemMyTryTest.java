package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseADefaultItemMyTryTest {

	public static final int NOT_EXPIRED_SELL_IN = 15;
	public static final int INITIAL_QUALITY = 3;
	public static final int NEGATIVE_SELL_IN = -1;
	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";


	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 1 when the item is not expired
	 * and sell in should decrease by 1.
	 * 
	 */

	/* The Changes I made in this file
	*    1. Making arrays to list
	*    2. Making variables in item class private and adding getters to get it
	*    3. Making constants.
	*    4. Extractions lines into small methods
	* */
	@Test
	public void testUpdateQualityDefault1() {
		GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN, INITIAL_QUALITY);
		
		app.updateQuality();
		
		Item actualItem = app.items.get(0);
		Item expectedItem = new Item(DEFAULT_ITEM,NOT_EXPIRED_SELL_IN -1, INITIAL_QUALITY -1);
		assertItem(expectedItem, actualItem);
	}

	private GildedRose createGildedRoseWithItem(String itemName, int sellIn, int quality) {
		Item item = new Item(itemName, sellIn, quality); // Here we changed to constant because for better readability
		List<Item> items = new ArrayList<>();
		items.add(item);
		return new GildedRose(items);
	}


	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
	 * 
	 */
	@Test
	public void testUpdateQualityForExpiredItem() {
		GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM, NEGATIVE_SELL_IN, INITIAL_QUALITY);

		app.updateQuality();

		Item actualItem = app.items.get(0);
		Item expectedItem = new Item(DEFAULT_ITEM,NEGATIVE_SELL_IN -1,  INITIAL_QUALITY-2);
		assertItem(expectedItem, actualItem);
	}

	private void assertItem(Item expectedItem, Item actualItem) {
		assertEquals(expectedItem.getName(), actualItem.getName());
		assertEquals(expectedItem.getSellIn(), actualItem.getSellIn());
		assertEquals(expectedItem.getQuality(), actualItem.getQuality());
	}
}
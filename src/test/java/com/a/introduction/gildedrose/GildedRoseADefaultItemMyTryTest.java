package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseADefaultItemMyTryTest {
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
	* */
	@Test
	public void testUpdateQualityDefault1() {
		Item item = new Item("DEFAULT_ITEM", 15, 3);
		List<Item> items = new ArrayList();
		items.add(item);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("DEFAULT_ITEM", app.items.get(0).getName());
		assertEquals(14, app.items.get(0).getSellIn());
		assertEquals(2, app.items.get(0).getQuality());
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
		Item item = new Item("DEFAULT_ITEM", -1, 3);
		List<Item> items = new ArrayList();
		items.add(item);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("DEFAULT_ITEM", app.items.get(0).getName());
		assertEquals(-2, app.items.get(0).getSellIn());
		assertEquals(1, app.items.get(0).getQuality());
	}
}
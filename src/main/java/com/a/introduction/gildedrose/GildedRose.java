package com.a.introduction.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GildedRose {
	
	List<Item> items;

	public GildedRose(List<Item> items) {
		this.items = items;
	}

	public static void main(String[] args) {

		List<Item> items = new ArrayList<>();
		Item item = new Item("Default Item", 10, 20);
		items.add(item);

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		System.out.println(app);

	}

	public void updateQuality() {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName() != "Aged Brie" && items.get(i).getName() != "Backstage passes to a TAFKAL80ETC concert") {
				if (items.get(i).getQuality() > 0) {
					if (items.get(i).getName() != "Sulfuras, Hand of Ragnaros") {
						items.get(i).setQuality(items.get(i).getQuality() - 1);
					}
				}
			} else {
				// This part handles the items for which getQuality() can increase
				// "Backstage passes to a TAFKAL80ETC concert" and "Aged Brie"

				if (items.get(i).getQuality() < 50) {
					items.get(i).setQuality(items.get(i).getQuality() + 1);

					if (items.get(i).getName() == "Backstage passes to a TAFKAL80ETC concert") {
						if (items.get(i).getSellIn() < 11) {
							if (items.get(i).getQuality() < 50) {
								items.get(i).setQuality(items.get(i).getQuality() + 1);
							}
						}

						if (items.get(i).getSellIn() < 6) {
							if (items.get(i).getQuality() < 50) {
								items.get(i).setQuality(items.get(i).getQuality() + 1);
							}
						}
					}
				}
			}

			// Everything except for Sulfuras the getSellIn() Decreases
			if (items.get(i).getName() != "Sulfuras, Hand of Ragnaros") {
				items.get(i).setSellIn(items.get(i).getSellIn() - 1);
			}

			if (items.get(i).getSellIn() < 0) {
				if (items.get(i).getName() != "Aged Brie") {

					if (items.get(i).getName() != "Backstage passes to a TAFKAL80ETC concert") {
						if (items.get(i).getQuality() > 0) {
							if (items.get(i).getName() != "Sulfuras, Hand of Ragnaros") {
								items.get(i).setQuality(items.get(i).getQuality() - 1);
							}
						}
					} else {
						// For Backstage passes with sellin less than zero
						// getQuality() is set to zero
						items.get(i).setQuality(0);
					}
				} else {
					// For Aged Brie below 50 getQuality() increases actually by 2
					// In the previous line
					if (items.get(i).getQuality() < 50) {
						items.get(i).setQuality(items.get(i).getQuality() + 1);
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return items.toString();
	}

}
package com.alexaitken.gildedrose;

public class Inventory {

	private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String _5_DEXTERITY_VEST = "+5 Dexterity Vest";
	private Item[] items;

	public Inventory(Item[] items) {
		super();
		this.items = items;
	}

	public Inventory() {
		super();
		items = new Item[] { new Item(_5_DEXTERITY_VEST, 10, 20), new Item(AGED_BRIE, 2, 0),
				new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7), new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80),
				new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 15, 20), new Item(CONJURED_MANA_CAKE, 3, 6) };

	}

	public void updateQuality() {
		for (Item item : items) {
			ItemUpdater updater = getItemUpdater(item);
			updater.updateQuality();
			updater.updateSellIn();
			if (item.getSellIn() < 0) {
				updater.updateQualityAfterSellin();
			}
		}
	}

	private ItemUpdater getItemUpdater(Item item) {
		switch (item.getName()) {
		case AGED_BRIE:
			return new AgedBrieItemUpdater(item);
		case SULFURAS_HAND_OF_RAGNAROS:
			return new SulfurasItemUpdater(item);
		case BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT:
			return new BackstagePassItemUpdater(item);
		default:
			return new DefaultItemUpdater(item);
		}
	}
}

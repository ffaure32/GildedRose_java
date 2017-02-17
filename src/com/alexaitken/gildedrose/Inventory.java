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
		items = new Item[] {
					new Item(_5_DEXTERITY_VEST, 10, 20), 
					new Item(AGED_BRIE, 2, 0),
					new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7),
					new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80),
					new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 15, 20),
					new Item(CONJURED_MANA_CAKE, 3, 6) 
				};

	}

	public void updateQuality() {
		for (Item item : items) {
			if (item.getName() != AGED_BRIE
					&& item.getName() != BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT) {
				if (item.getQuality() > 0) {
					if (item.getName() != SULFURAS_HAND_OF_RAGNAROS) {
						item.setQuality(item.getQuality() - 1);
					}
				}
			} else {
				if (item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);

					if (item.getName() == BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT) {
						if (item.getSellIn() < 11) {
							if (item.getQuality() < 50) {
								item.setQuality(item.getQuality() + 1);
							}
						}

						if (item.getSellIn() < 6) {
							if (item.getQuality() < 50) {
								item.setQuality(item.getQuality() + 1);
							}
						}
					}
				}
			}

			if (item.getName() != SULFURAS_HAND_OF_RAGNAROS) {
				item.setSellIn(item.getSellIn() - 1);
			}

			if (item.getSellIn() < 0) {
				if (item.getName() != AGED_BRIE) {
					if (item.getName() != BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT) {
						if (item.getQuality() > 0) {
							if (item.getName() != SULFURAS_HAND_OF_RAGNAROS) {
								item.setQuality(item.getQuality() - 1);
							}
						}
					} else {
						item.setQuality(item.getQuality()
								- item.getQuality());
					}
				} else {
					if (item.getQuality() < 50) {
						item.setQuality(item.getQuality() + 1);
					}
				}
			}
		}
	}
}

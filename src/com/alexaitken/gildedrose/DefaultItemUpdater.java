package com.alexaitken.gildedrose;

public class DefaultItemUpdater implements ItemUpdater {
	protected Item item;

	public DefaultItemUpdater(Item item) {
		super();
		this.item = item;
	}

	@Override
	public void updateQuality() {
		if (item.getQuality() > 0) {
			item.setQuality(item.getQuality() - 1);
		}
	}

	@Override
	public void updateSellIn() {
		item.setSellIn(item.getSellIn() - 1);
	}

	@Override
	public void updateQualityAfterSellin() {
		if (item.getQuality() > 0) {
			item.setQuality(item.getQuality() - 1);
		}
	}
	
	
}

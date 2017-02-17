package com.alexaitken.gildedrose;

public class DefaultItemUpdater implements ItemUpdater {
	protected Item item;

	public DefaultItemUpdater(Item item) {
		super();
		this.item = item;
	}

	@Override
	public void updateQuality() {
		decreaseQualityIfPositive();
	}

	@Override
	public void updateSellIn() {
		item.setSellIn(item.getSellIn() - 1);
	}

	@Override
	public void updateQualityAfterSellin() {
		decreaseQualityIfPositive();
	}

	protected void decreaseQualityIfPositive() {
		if (item.getQuality() > 0) {
			item.setQuality(item.getQuality() - 1);
		}
	}
	
	protected void raiseQualityIfMaxNotReached() {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
		}
	}



	
	
}

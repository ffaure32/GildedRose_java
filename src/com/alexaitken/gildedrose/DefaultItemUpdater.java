package com.alexaitken.gildedrose;

public class DefaultItemUpdater implements ItemUpdater {
	private static final int MIN_QUALITY = 0;
	protected static final int MAX_QUALITY = 50;
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
		item.setQuality(Math.max(MIN_QUALITY, item.getQuality()-1));
	}
	
	protected void raiseQualityIfMaxNotReached() {
		item.setQuality(Math.min(MAX_QUALITY, item.getQuality()+1));
	}



	
	
}

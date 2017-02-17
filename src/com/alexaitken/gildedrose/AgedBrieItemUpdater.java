package com.alexaitken.gildedrose;

public class AgedBrieItemUpdater extends DefaultItemUpdater {

	public AgedBrieItemUpdater(Item item) {
		super(item);
	}

	@Override
	public void updateQualityAfterSellin() {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
		}
	}

	@Override
	public void updateQuality() {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
		}
	}
}

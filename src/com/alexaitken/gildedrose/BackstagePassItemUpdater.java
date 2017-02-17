package com.alexaitken.gildedrose;

public class BackstagePassItemUpdater extends DefaultItemUpdater {

	public BackstagePassItemUpdater(Item item) {
		super(item);
	}

	@Override
	public void updateQualityAfterSellin() {
		item.setQuality(0);
	}

	@Override
	public void updateQuality() {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);

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

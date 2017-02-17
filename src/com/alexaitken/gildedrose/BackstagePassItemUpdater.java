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
		if (item.getSellIn() <= 5) {
			raiseQualityIfMaxNotReached();
			raiseQualityIfMaxNotReached();
			raiseQualityIfMaxNotReached();
		} else if(item.getSellIn() <= 10) {
			raiseQualityIfMaxNotReached();
			raiseQualityIfMaxNotReached();
		} else {
			raiseQualityIfMaxNotReached();
		}
	}
}

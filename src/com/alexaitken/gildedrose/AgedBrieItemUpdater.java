package com.alexaitken.gildedrose;

public class AgedBrieItemUpdater extends DefaultItemUpdater {

	public AgedBrieItemUpdater(Item item) {
		super(item);
	}

	@Override
	public void updateQualityAfterSellin() {
		raiseQualityIfMaxNotReached();
	}

	@Override
	public void updateQuality() {
		raiseQualityIfMaxNotReached();
	}
}

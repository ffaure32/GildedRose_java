package com.alexaitken.gildedrose;

public class BackstagePassItemUpdater extends DefaultItemUpdater {

	private static final int DAY_LIMIT_TO_DOUBLE_RAISE = 10;
	private static final int DAY_LIMIT_TO_TRIPLE_RAISE = 5;

	public BackstagePassItemUpdater(Item item) {
		super(item);
	}

	@Override
	public void updateQualityAfterSellin() {
		item.setQuality(0);
	}

	@Override
	public void updateQuality() {
		if (item.getSellIn() <= DAY_LIMIT_TO_TRIPLE_RAISE) {
			raiseQualityIfMaxNotReached();
			raiseQualityIfMaxNotReached();
			raiseQualityIfMaxNotReached();
		} else if(item.getSellIn() <= DAY_LIMIT_TO_DOUBLE_RAISE) {
			raiseQualityIfMaxNotReached();
			raiseQualityIfMaxNotReached();
		} else {
			raiseQualityIfMaxNotReached();
		}
	}
}

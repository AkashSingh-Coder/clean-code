package org.example.exercises;

import java.util.Arrays;

public class OlxApp {

	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;
	private static final int INCREASE_STEP = 1;
	private static final int DECREASE_STEP = 1;
	private static final int BACKSTAGE_FIRST_THRESHOLD = 11;
	private static final int BACKSTAGE_SECOND_THRESHOLD = 6;

	private static final String ITEM_AGED_WINE = "Aged Wine";
	private static final String ITEM_BACKSTAGE_PASSES = "ColdPlay concert passes";
	private static final String ITEM_POKEMONGO = "PokemonGo";

	public Item[] items;

	public OlxApp(Item[] items) {
		this.items = items;
	}

	public static void main(String[] args) {
		Item[] items = new Item[] {
				new Item("Mangoes", 10, 20)
		};

		OlxApp app = new OlxApp(items);
		app.updateQuality();
		System.out.println(app);
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals(ITEM_AGED_WINE) && !items[i].name.equals(ITEM_BACKSTAGE_PASSES)) {
				if (items[i].quality > MIN_QUALITY) {
					if (!items[i].name.equals(ITEM_POKEMONGO)) {
						items[i].quality = items[i].quality - DECREASE_STEP;
					}
				}
			} else {
				if (items[i].quality < MAX_QUALITY) {
					items[i].quality = items[i].quality + INCREASE_STEP;

					if (items[i].name.equals(ITEM_BACKSTAGE_PASSES)) {
						if (items[i].sellIn < BACKSTAGE_FIRST_THRESHOLD) {
							if (items[i].quality < MAX_QUALITY) {
								items[i].quality = items[i].quality + INCREASE_STEP;
							}
						}

						if (items[i].sellIn < BACKSTAGE_SECOND_THRESHOLD) {
							if (items[i].quality < MAX_QUALITY) {
								items[i].quality = items[i].quality + INCREASE_STEP;
							}
						}
					}
				}
			}

			if (!items[i].name.equals(ITEM_POKEMONGO)) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals(ITEM_AGED_WINE)) {
					if (!items[i].name.equals(ITEM_BACKSTAGE_PASSES)) {
						if (items[i].quality > MIN_QUALITY) {
							if (!items[i].name.equals(ITEM_POKEMONGO)) {
								items[i].quality = items[i].quality - DECREASE_STEP;
							}
						}
					} else {
						items[i].quality = MIN_QUALITY;
					}
				} else {
					if (items[i].quality < MAX_QUALITY) {
						items[i].quality = items[i].quality + INCREASE_STEP;
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}
}

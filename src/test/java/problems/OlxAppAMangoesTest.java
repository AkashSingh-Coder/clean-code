package problems;

import org.example.exercises.Item;
import org.example.exercises.OlxApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OlxAppAMangoesTest {
	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * The quality should decrease by 1 when the item is not expired
	 * and sell in should decrease by 1.
	 */
	@Test
	public void testUpdateQualityMangoes1() {
		Item item = new Item("Mangoes", 15, 3);
		Item[] items = new Item[] { item };
		OlxApp app = new OlxApp(items);
		app.updateQuality();
		assertEquals("Mangoes", app.items[0].name);
		assertEquals(14, app.items[0].sellIn);
		assertEquals(2, app.items[0].quality) ;
	}

	/**
	 * Method to test the variation in quality of the item for the expired
	 * Item.
	 * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
	 */
	@Test
	public void testUpdateQualityForExpiredItem() {
		Item item = new Item("Mangoes", -1, 3);
		Item[] items = new Item[] { item };
		OlxApp app = new OlxApp(items);
		app.updateQuality();
		assertEquals("Mangoes", app.items[0].name);
		assertEquals(-2, app.items[0].sellIn);
		assertEquals(1, app.items[0].quality);
	}
}
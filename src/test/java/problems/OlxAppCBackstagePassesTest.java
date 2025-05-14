package problems;

import org.example.exercises.Item;
import org.example.exercises.OlxApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OlxAppCBackstagePassesTest {
	
	private static final String NAME = "ColdPlay concert passes";

	OlxApp createOlxAppWithItem(String name,int sellin,int quality){
		Item item=new Item(name,sellin,quality);
		Item[] items = new Item[] { item };
		OlxApp app = new OlxApp(items);
		return app;
	}
	@Test
	public void testUpdateQualityBackstagePasses1() {
		OlxApp app = createOlxAppWithItem(NAME,15,3);

		app.updateQuality();
		
		Item item=new Item(NAME, 14, 4);
		assertEqualByValues(item,app.items[0]);
	}

	@Test
	public void testUpdateQualityBackstagePasses2() {
		Item item = new Item(NAME, 7, 3);
		Item[] items = new Item[] { item };
		OlxApp app = new OlxApp(items);
		app.updateQuality();
		assertEquals(NAME,
				app.items[0].name);
		assertEquals(6, app.items[0].sellIn);
		assertEquals(5, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses3() {
		Item item = new Item(NAME, 4, 3);
		Item[] items = new Item[] { item };
		OlxApp app = new OlxApp(items);
		app.updateQuality();
		assertEquals(NAME,
				app.items[0].name);
		assertEquals(3, app.items[0].sellIn);
		assertEquals(6, app.items[0].quality);
	}

	void assertEqualByValues(Item item,Item item2){
		assertEquals(item.name,item2.name);
		assertEquals(item.sellIn,item2.sellIn);
		assertEquals(item.quality,item2.quality);
	}
}
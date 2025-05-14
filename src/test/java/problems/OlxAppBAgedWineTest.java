package problems;

import org.example.exercises.Item;
import org.example.exercises.OlxApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OlxAppBagedWineTest {

	OlxApp createOlxAppWithItem(String wine,int sellin,int quality){
		Item item=new Item(wine,sellin,quality);
		Item[] items = new Item[] { item };
		OlxApp app = new OlxApp(items);
		return app;
	}

	@Test
	public void testUpdateQualityAgedWine1_SellinDecrease1_QualityIncrease1() {
		OlxApp app=createOlxAppWithItem("Aged Wine",4,3);

		app.updateQuality();

		Item item=new Item("Aged Wine", 3, 4);
		assertEqualByValues(item,app.items[0]);
	}

	@Test
	public void testUpdateQualityAgedWine2_SellinDecrease1_QualityIncrease2() {
		OlxApp app=createOlxAppWithItem("Aged Wine",-1,3);

		app.updateQuality();

		Item item=new Item("Aged Wine", -2, 5);
		assertEqualByValues(item, app.items[0]);
	}

	@Test
	public void testUpdateQualityAgedWine3() {
		OlxApp app=createOlxAppWithItem("Aged Wine",4,50);

		app.updateQuality();

		Item item=new Item("Aged Wine", 3, 50);
		assertEqualByValues(item, app.items[0]);
		
	}

	void assertEqualByValues(Item item,Item item2){
		assertEquals(item.name,item2.name);
		assertEquals(item.sellIn,item2.sellIn);
		assertEquals(item.quality,item2.quality);
	}
}

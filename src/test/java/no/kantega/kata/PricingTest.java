package no.kantega.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PricingTest {

  private ItemRegistry itemRegistry;

  @BeforeEach
  void setUp() {
    itemRegistry = new ItemRegistry();
  }

  @Test
  void registeringItemSavesItemInRegistry() {
    Item item = new Item("Tannkrem", 25);

    itemRegistry.register(item);

    assertTrue(itemRegistry.hasItem(item), "Has registered an item");
  }

  @Test
  void registeringTheSameItemTwiceDoesNotCreateDuplicates() {
    Item item = new Item("Tannkrem", 25);
    Item item2 = new Item("Tannkrem", 25);

    itemRegistry.register(item);
    itemRegistry.register(item2);

    assertEquals(1,itemRegistry.getNumberOfRegisteredItems(), "Has only one item after registering two identical items");
  }

  @Test
  void scanningItemNotInRegistryReturnsUnchangedSum() {
    Item item = new Item("Tannkrem", 25);

    double sum = itemRegistry.scan(item);

    assertEquals(0, sum, "Sum after scanning one item");
  }

  @Test
  void scanningAnItemWithPriceTenReturnsSumEqualsTen() {
    Item item = new Item("Tannbørste", 10);
    itemRegistry.register(item);

    double result = itemRegistry.scan(item);

    assertEquals(10, result, "Sum after scanning one item");
  }

  @Test
  void scanningAnItemAddsItemToReceipt() {
    Item item = new Item("Tannbørste", 10);
    itemRegistry.register(item);

    itemRegistry.scan(item);

    String result = itemRegistry.getReceipt();

    assertEquals("Tannbørste", result, "Receipt after scanning one 'tannbørste' item");
  }

  @Test
  void scanningTwoItemsWithPriceTenReturnsSumEqualsTwenty() {
    Item item = new Item("Tannbørste", 10);
    itemRegistry.register(item);

    itemRegistry.scan(item);
    double result = itemRegistry.scan(item);

    assertEquals(20, result, "Sum after scanning two items");
  }


}

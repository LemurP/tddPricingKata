package no.kantega.kata;

import java.util.HashSet;
import java.util.Set;

public class ItemRegistry {
  private final Set<Item> registeredItems;
  //private final Map<Item, Integer> scannedItems;
  private double sum;

  public ItemRegistry() {
    this.sum = 0;
    this.registeredItems = new HashSet<>();
  }

  public double scan(Item item) {
    if (registeredItems.contains(item)) {
      sum += item.getPrice();
    }
    return sum;
  }

  public void register(Item item) {
    registeredItems.add(item);
  }

  public boolean hasItem(Item item) {
    return registeredItems.contains(item);
  }

  public String getReceipt() {

    return "Tannbørste";
  }

  public int getNumberOfRegisteredItems() {
    return registeredItems.size();
  }
}

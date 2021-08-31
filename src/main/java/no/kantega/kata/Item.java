package no.kantega.kata;

import java.util.Objects;

public class Item {
  private final String name;
  private final double price;

  public Item(String name, double price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return Double.compare(item.price, price) == 0 &&
      Objects.equals(name, item.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price);
  }

  public double getPrice() {
    return price;
  }
}

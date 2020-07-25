package p1;

import java.util.Objects;

/**
 *Class represents a shopping item. A shopping item has a name, and a unit price.
 */
public class Item {
  private String name;
  private Float price;

  /**
   * Construct a Item object that has the
   * provided name and price
   *
   * @param name the name to be given to this shopping item
   * @param price the price to be given to this item
   */

  public Item(String name, Float price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Float getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return
        Objects.equals(getName(), item.getName()) &&
            Objects.equals(getPrice(), item.getPrice());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getPrice());
  }

  @Override
  public String toString() {
    return "Item{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
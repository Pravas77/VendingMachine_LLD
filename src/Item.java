import java.util.Objects;

public class Item {
    private int id;
    private ItemType itemType;
    private int price;

    public Item(int id, ItemType itemType, int price) {
        this.id = id;
        this.itemType = itemType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && price == item.price && itemType == item.itemType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemType, price);
    }
}

package linked_list.singly_linked_list.inventory;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;

    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

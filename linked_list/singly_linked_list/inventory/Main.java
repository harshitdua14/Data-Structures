package linked_list.singly_linked_list.inventory;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addAtEnd("Keyboard", 101, 50, 25.99);
        inventory.addAtBeginning("Mouse", 102, 100, 15.75);
        inventory.addAtPosition(2, "Monitor", 103, 30, 125.50);

        inventory.displayAll();

        inventory.updateQuantity(101, 60);
        inventory.searchItem("102");
        inventory.searchItem("Monitor");

        inventory.calculateTotalValue();

        inventory.sort("name", true);
        inventory.displayAll();

        inventory.sort("price", false);
        inventory.displayAll();
    }
}


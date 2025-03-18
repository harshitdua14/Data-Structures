package linked_list.singly_linked_list.inventory;

public class Inventory {
    private Item head;

    // Add item at beginning
    public void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if(head == null) {
        	head = newItem;
        	return;
        }
        newItem.next = head;
        head = newItem;
    }

    // Add item at end
    public void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add item at specific position (1-based)
    public void addAtPosition(int position, String name, int id, int quantity, double price) {
        if (position <= 1) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(name, id, quantity, price);
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove item by ID
    public void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed: " + id);
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item ID not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed: " + id);
        }
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    // Search by ID or Name
    public void searchItem(String keyword) {
        boolean found = false;
        Item temp = head;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(keyword) || temp.itemName.equalsIgnoreCase(keyword)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found: " + keyword);
    }

    // Display all items
    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Current Inventory:");
        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + total);
    }

    // Sort by Item Name or Price (ascending or descending)
    public void sort(String key, boolean ascending) {
        head = mergeSort(head, key, ascending);
        System.out.println("Inventory sorted by " + key + " (" + (ascending ? "ASC" : "DESC") + ")");
    }

    // Merge Sort for Linked List
    private Item mergeSort(Item head, String key, boolean ascending) {
        if (head == null || head.next == null) return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, key, ascending);
        Item right = mergeSort(nextOfMiddle, key, ascending);

        return sortedMerge(left, right, key, ascending);
    }

    private Item sortedMerge(Item a, Item b, String key, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (key.equalsIgnoreCase("name")) {
            condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                                  : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = ascending ? a.price <= b.price : a.price > b.price;
        }

        Item result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, key, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, key, ascending);
        }

        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper to display one item
    private void displayItem(Item item) {
        System.out.println("ID: " + item.itemId + ", Name: " + item.itemName +
                ", Qty: " + item.quantity + ", Price: $" + item.price);
    }
}


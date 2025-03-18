package st_queue_hash.hashmap_hashfunction.custom_hashmap;

import java.util.LinkedList;

class MyHashMap {
    private static final int SIZE = 1000;
    
    // Node class for key-value pair
    private static class Node {
        int key;
        int value;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    
    private LinkedList<Node>[] map;

    // Constructor
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    // PUT operation
    public void put(int key, int value) {
        int index = getIndex(key);

        if (map[index] == null)
            map[index] = new LinkedList<>();

        for (Node node : map[index]) {
            if (node.key == key) {
                node.value = value;  // Update existing
                return;
            }
        }

        map[index].add(new Node(key, value)); // Insert new
    }

    // GET operation
    public int get(int key) {
        int index = getIndex(key);

        if (map[index] == null) return -1;

        for (Node node : map[index]) {
            if (node.key == key) return node.value;
        }

        return -1; // Not found
    }

    // REMOVE operation
    public void remove(int key) {
        int index = getIndex(key);

        if (map[index] == null) return;

        map[index].removeIf(node -> node.key == key);
    }
}

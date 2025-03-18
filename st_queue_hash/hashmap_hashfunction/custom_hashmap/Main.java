package st_queue_hash.hashmap_hashfunction.custom_hashmap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMap map = new MyHashMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);

        System.out.println("Get 2: " + map.get(2)); // 200
        map.remove(2);
        System.out.println("Get 2 after removal: " + map.get(2)); //-1
	}

}

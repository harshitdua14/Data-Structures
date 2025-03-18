package st_queue_hash.stack_queue.circular_tour;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 PetrolPump[] pumps = {
		            new PetrolPump(4, 6),
		            new PetrolPump(6, 5),
		            new PetrolPump(7, 3),
		            new PetrolPump(4, 5)
		        };

		        int startIndex = PetrolPump.findStartingPoint(pumps);

		        if (startIndex != -1) {
		            System.out.println("Truck can complete tour starting at pump index: " + startIndex);
		        } else {
		            System.out.println("Tour not possible from any pump.");
		        }
	}

}

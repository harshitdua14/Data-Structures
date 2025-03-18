package st_queue_hash.stack_queue.circular_tour;
import java.util.LinkedList;
import java.util.Queue;
class PetrolPump{
	int petrol;
	int distance;
	PetrolPump(int petrol,int distance){
		this.petrol = petrol;
		this.distance = distance;
	}
 
	 // Returns the starting pump index, or -1 if not possible
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;

        for (int start = 0; start < n; start++) {
            int fuel = 0;
            int count = 0;

            Queue<Integer> q = new LinkedList<>();
            int i = start;

            while (count < n) {
                fuel += pumps[i].petrol - pumps[i].distance;
                q.offer(i);

                if (fuel < 0) {
                    break; // This start fails
                }

                i = (i + 1) % n;
                count++;
            }

            if (count == n && fuel >= 0) {
                return start;
            }

            // Clear queue and try next pump
            q.clear();
        }

        return -1;
    }
}

package st_queue_hash.stack_queue.slidin_window;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> maxWindow = SlidingWindowMax.calculate(arr, k);

        System.out.println("Sliding window maximums:");
        for (int max : maxWindow) {
            System.out.print(max + " ");
        }
	}

}

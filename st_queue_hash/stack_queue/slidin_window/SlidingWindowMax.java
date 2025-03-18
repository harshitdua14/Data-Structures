package st_queue_hash.stack_queue.slidin_window;
import java.util.List;
import java.util.Deque; 
import java.util.ArrayList;
import java.util.LinkedList;
public class SlidingWindowMax {
	static List<Integer> calculate(int[]arr,int k){
		List<Integer>result = new ArrayList<>();
		Deque<Integer>deque = new LinkedList<>();
		for(int i=0;i<arr.length;i++) {
				while(!deque.isEmpty() && deque.peekFirst() <= i-k) {
					deque.pollFirst();
				}
				while(!deque.isEmpty() && arr[deque.peekLast()]< arr[i]) {
					deque.pollLast();
				}
				
				deque.offerLast(i);                                                               
				
				if(i>=k-1) {
					result.add(arr[deque.peekFirst()]);
				}
		}
		return result;
	}
}

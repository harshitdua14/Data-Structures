package st_queue_hash.stack_queue.stack_span;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {100,80,60,70,60,75,85};
		int n = arr.length;
		ArrayList<Integer>span = StackSpan.calculate(arr,n);
		for(int i:span) {
			System.out.println(i);
		}
	}

}

package st_queue_hash.stack_queue.stack_span;
import java.util.Stack;
import java.util.ArrayList;
public class StackSpan {
	static ArrayList<Integer> calculate(int[]arr,int n){
		ArrayList<Integer>calculatedSpan = new ArrayList<>();
		Stack<Integer>st = new Stack<>();
		for(int i=0;i<n;i++) {
			while(!st.isEmpty() && arr[st.peek()]<=arr[i]) {
				st.pop();
			}
			
			if(st.isEmpty()) {
				calculatedSpan.add(i,i+1);
			}
			else {
				calculatedSpan.add(i, i-st.peek());
				
			}
			st.push(i);
		}
		return calculatedSpan;
	}
}

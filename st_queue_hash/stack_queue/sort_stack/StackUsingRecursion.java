package st_queue_hash.stack_queue.sort_stack;
import java.util.Stack;
public class StackUsingRecursion {
     static void sortStack(Stack<Integer>st) {
    	 if(!st.isEmpty()) {
    		 int top = st.pop();
    		 sortStack(st);
    		 insertInSortedOrder(st,top);
    	 }
     }
      
    static void insertInSortedOrder(Stack<Integer>st,int element) {
    	 if(st.isEmpty() || element>=st.peek()) {
    		 st.push(element);
    		 return;
    	 }
	    	 int top = st.pop();
	    	 insertInSortedOrder(st,element);
	    	 st.push(top);
     }
     
    static void display(Stack<Integer>st) {
    	 if(!st.isEmpty()) {
    		 for(int i=0;i<st.size();i++) {
    			 System.out.println(st.get(i)+" ");
    		 }
    	 }
    	
     }
}

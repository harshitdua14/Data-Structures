package st_queue_hash.stack_queue.queue_using_stack;
import java.util.Stack;
public class StackToQueue {
   Stack<Integer>en;
   Stack<Integer>de;
   StackToQueue(){
	   this.en = new Stack<Integer>();
	   this.de = new Stack<Integer>();
   }
   
   //insert element
   void enqueue(int x) {
	   en.add(x);
   }
   
   //remove element
   
   int dequeue() {
	   if(isEmpty()) {
		   throw new RuntimeException("Queue is Empty");
	   }
	   shiftStacks();
	   return de.pop();
   }
   
   int peek() {
	   if(isEmpty()) {
		   throw new RuntimeException("Queue is empty");
	   }
	   shiftStacks();
	   return de.peek();
   }
   
    boolean isEmpty()
    {
    	return en.isEmpty() && de.isEmpty();
    }
    
    private void shiftStacks() {
        if (de.isEmpty()) {
            while (!en.isEmpty()) {
                de.push(en.pop());
            }
        }
    }
   
}

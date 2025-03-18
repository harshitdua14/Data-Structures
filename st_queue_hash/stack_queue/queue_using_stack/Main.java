package st_queue_hash.stack_queue.queue_using_stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackToQueue queue = new StackToQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.peek());    // 20
        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.dequeue()); // 30
        System.out.println(queue.isEmpty()); // true

	}

}

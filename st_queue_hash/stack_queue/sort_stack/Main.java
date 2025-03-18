package st_queue_hash.stack_queue.sort_stack;
import java.util.Stack;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        System.out.println("Original Stack (top to bottom):");
        StackUsingRecursion.display(st);

        StackUsingRecursion.sortStack(st); // Call your recursive sort method

        System.out.println("Sorted Stack (top to bottom):");
        StackUsingRecursion.display(st);

        sc.close();
	}

}

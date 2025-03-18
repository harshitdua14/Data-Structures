package Sorting.bubble_sort;
import java.util.Scanner;
public class SortStudentMarks {
	private static void BubbleSort(int[]arr) {
		int n = arr.length;
		boolean swapped;
		for(int i=0;i<n-1;i++) {
			swapped = false;
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] =temp;
					swapped = true;
				}
				if(!swapped) {
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter no. of Student");
		int numOfStudent = input.nextInt();
		int[] studentMarks = new int[numOfStudent];
		System.out.print("Enter the marks :");
		for(int i=0;i<numOfStudent;i++) {
			studentMarks[i]=input.nextInt();
		}
		BubbleSort(studentMarks);
		System.out.println("Sorted marks:");
	        for (int mark : studentMarks) {
	            System.out.print(mark + " ");
	        }
	        
	     input.close();
	}

}

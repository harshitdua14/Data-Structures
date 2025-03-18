package Sorting.InsertionSort;
import java.util.Scanner;
public class SortEmployeId {
	public static void insertionSort(int[]arr) {
		int n = arr.length;
		for(int i=1;i<n;i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner input = new Scanner(System.in);
	        System.out.print("Enter number of employees: ");
	        int n = input.nextInt();

	        int[] employeeIDs = new int[n];
	        System.out.println("Enter employee IDs:");
	        for (int i = 0; i < n; i++) {
	            employeeIDs[i] = input.nextInt();
	        }

	        insertionSort(employeeIDs);

	        System.out.println("Sorted Employee IDs:");
	        for (int id : employeeIDs) {
	            System.out.print(id + " ");
	        }

	        input.close();
	}

}

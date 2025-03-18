package Sorting.count_sort;

import java.util.Scanner;

public class CountingSortStudentAges {

    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];       // Step 1: count array
        int[] output = new int[ages.length]; // Step 2: output array

        // Step 3: Count frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 4: Cumulative count (prefix sum)
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 5: Build output array (iterate from end for stable sort)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Step 6: Copy output to original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter student ages (10-18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }

        countingSort(ages);

        System.out.println("Sorted Student Ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }

        scanner.close();
    }
}


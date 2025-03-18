package st_queue_hash.hashmap_hashfunction.subarray_zero_sum;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class ZeroSumSubarray {
	public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum == 0, subarray from 0 to i
            if (sum == 0) {
                result.add(new int[]{0, i});
            }

            // If sum has been seen before
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            // Store current sum with current index
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    // Helper to print result
    public static void printSubarrays(int[] arr) {
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        for (int[] sub : subarrays) {
            System.out.print("Subarray from " + sub[0] + " to " + sub[1] + ": ");
            for (int i = sub[0]; i <= sub[1]; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

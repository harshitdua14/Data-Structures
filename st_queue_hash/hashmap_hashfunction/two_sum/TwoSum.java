package st_queue_hash.hashmap_hashfunction.two_sum;
import java.util.HashMap;
public class TwoSum {
	public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // found
            }

            map.put(nums[i], i); // store current value and index
        }

        return new int[] { -1, -1 }; // no pair found
    }
}

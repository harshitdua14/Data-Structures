package st_queue_hash.hashmap_hashfunction.consecutive_seq;
import java.util.Set;
import java.util.HashSet;
public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;

        // Add all numbers to set
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
	}
}

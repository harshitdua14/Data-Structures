package st_queue_hash.hashmap_hashfunction.check_pair;
import java.util.Set;
import java.util.HashSet;
public class PairWithTargetSum {
	public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }

            seen.add(num);
        }

        System.out.println("No pair with given sum found.");
        return false;
	}
}

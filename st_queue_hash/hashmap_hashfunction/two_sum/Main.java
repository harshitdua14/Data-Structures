package st_queue_hash.hashmap_hashfunction.two_sum;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = TwoSum.findTwoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
	}

}

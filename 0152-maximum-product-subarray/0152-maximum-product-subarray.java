class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        double max_so_far = nums[0];
        double min_so_far = nums[0];
        double result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            double temp_max = Math.max(
                curr,
                Math.max(max_so_far * curr, min_so_far * curr)
            );
            min_so_far = Math.min(
                curr,
                Math.min(max_so_far * curr, min_so_far * curr)
            );

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }
        return (int)result;
    }
}
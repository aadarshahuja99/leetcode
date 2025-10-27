class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            // temp max is the max possible product of a subarray that ends at index 'i'
            // to compute temp max, we need to consider for the max or min possible product ending at the previous index and add the current number to it, or we can only pick up the current number as the max possible product ending at the current index
            int temp_max = Math.max(
                curr,
                Math.max(max_so_far * curr, min_so_far * curr)
            );
            // same logic for min_so_far
            min_so_far = Math.min(
                curr,
                Math.min(max_so_far * curr, min_so_far * curr)
            );

            max_so_far = temp_max; // to ensure that max_so_far stores the max_so_far ending at the previous index for the next element in the array

            result = Math.max(max_so_far, result);
        }
        return (int)result;
    }
}
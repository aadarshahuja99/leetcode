class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums)
        {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return 1l*(max - min)*k;
    }
}
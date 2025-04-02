class Solution {
    public long maximumTripletValue(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        int[] maxes = new int[n];
        maxes[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--)
        {
            maxes[i] = Math.max(maxes[i+1], nums[i]);
        }
        long ans = Long.MIN_VALUE;
        for(int j=1; j<n-1; j++)
        {
            ans = Math.max(ans, 1l*(max - nums[j])*maxes[j+1]);
            max = Math.max(nums[j], max);
        }
        return Math.max(ans, 0);
    }
}
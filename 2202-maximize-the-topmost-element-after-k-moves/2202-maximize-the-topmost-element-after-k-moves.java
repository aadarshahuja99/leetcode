class Solution {
    public int maximumTop(int[] nums, int k) {
        if(nums.length == 1 && k%2 == 1)
        {
            return -1;
        }
        int n = nums.length;
        int lengthToBeTraversed = Math.min(k-1, n);
        int maxWithReplacement = -1;
        for(int i=0; i<lengthToBeTraversed; i++)
        {
            // System.out.println(maxWithReplacement+" "+i);
            maxWithReplacement = Math.max(maxWithReplacement, nums[i]);
        }
        int maxWithoutReplacement = 0;
        if(k <= n-1)
        {
            maxWithoutReplacement = nums[k];
        }
        return Math.max(maxWithoutReplacement, maxWithReplacement);
    }
}
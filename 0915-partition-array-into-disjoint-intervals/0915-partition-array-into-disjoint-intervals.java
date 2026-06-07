class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minFrom = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=n-1; i>0; i--)
        {
            min = Math.min(nums[i], min);
            minFrom[i] = min;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++)
        {
            max = Math.max(max, nums[i]);
            if(max <= minFrom[i+1])
            {
                return i+1;
            }
        }
        return -1;
    }
}
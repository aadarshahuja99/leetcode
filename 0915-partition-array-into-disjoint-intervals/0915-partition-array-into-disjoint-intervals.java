class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] maxTillNow = new int[n];
        int[] minPostNow = new int[n];
        maxTillNow[0] = nums[0];
        int max = nums[0];
        for(int i=1; i<n; i++)
        {
            max = Math.max(nums[i], max);
            maxTillNow[i] = max;
        }
        int min = nums[n-1];
        for(int i=n-2; i>=0; i--)
        {
            min = Math.min(min, nums[i+1]);
            minPostNow[i] = min;
        }
        for(int i=0; i<n-1; i++)
        {
            if(maxTillNow[i] <= minPostNow[i])
            {
                return i+1;
            }
        }
        return -1;
    }
}
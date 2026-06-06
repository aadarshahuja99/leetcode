class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int total = nums[0];
        for(int i=1; i<n; i++)
        {
            pre[i] = pre[i-1] + nums[i-1];
            total+=nums[i];
        }
        for(int i=0; i<n; i++)
        {
            if(pre[i] == (total - nums[i] - pre[i]))
            {
                return i;
            }
        }
        return -1;
    }
}
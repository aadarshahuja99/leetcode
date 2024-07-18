class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] ups = new int[n];
        int[] downs = new int[n];
        ups[0] = 1;
        downs[0] = 1;
        int ans = 1;
        for(int i=1; i<n; i++)
        {
            if(nums[i] > nums[i-1])
            {
                downs[i] = downs[i-1];
                ups[i] = downs[i-1] + 1;
            }
            else if(nums[i] < nums[i-1])
            {
                ups[i] = ups[i-1];
                downs[i] = ups[i-1] + 1;
            }
            else
            {
                ups[i] = ups[i-1];
                downs[i] = downs[i-1];
            }
            ans = Math.max(ans, Math.max(ups[i], downs[i]));
        }
        return ans;
    }
}
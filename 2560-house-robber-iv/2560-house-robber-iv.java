class Solution {
    public int minCapability(int[] nums, int k) {
        int minElement = nums[0];
        int maxElement = nums[0];
        int n = nums.length;
        for(int i=1; i<n; i++)
        {
            minElement = Math.min(nums[i], minElement);
            maxElement = Math.max(nums[i], maxElement);
        }
        int start = minElement;
        int end = maxElement;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(check(mid,nums,k))
            {
                ans = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int current, int[] nums, int k)
    {
        int previous = -2;
        for(int i=0; i<nums.length;)
        {
            if(current < nums[i])
            {
                i+=1;
                continue;
            }
            k--;
            if(k == 0)
            {
                return true;
            }
            previous=i;
            i+=2;
        }
        return false;
    }
}
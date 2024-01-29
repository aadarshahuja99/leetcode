class Solution {
    public int splitArray(int[] nums, int k) {
        int max = nums[0];
        int sum = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }
        int start = max;
        int end = sum;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(check(nums,mid,k))
            {
                end = mid-1;
                ans = mid;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int[] nums, int current, int k)
    {
        int idx = 0;
        int count = 0;
        while(idx < nums.length)
        {
            int sum = 0;
            while(idx<nums.length && sum+nums[idx] <= current)
            {
                sum += nums[idx];
                // System.out.println("sum = "+sum+" for element: "+count+" idx: "+idx+" current: "+current);
                idx++;
            }
            if(idx == nums.length)
            {
                if(sum <= current)
                {
                    count++;
                    break;
                }
            }
            count++;
        }
        // System.out.println("count = "+count+" for current: "+current);
        return count <= k;
    }
}
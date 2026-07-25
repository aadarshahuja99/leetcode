class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int num : nums)
        {
            max = Math.max(max, num);
        }
        int start = 1;
        int ans = -1;
        while(start <= max)
        {
            int mid = start + (max - start)/2;
            if(check(mid, threshold, nums))
            {
                ans = mid;
                max = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int current, int threshold, int[] nums)
    {
        int count = 0;
        for(int num : nums)
        {
            count += (int)Math.ceil((double)num/(double)current);
            if(count > threshold)
            {
                return false;
            }
        }
        return true;
    }
}
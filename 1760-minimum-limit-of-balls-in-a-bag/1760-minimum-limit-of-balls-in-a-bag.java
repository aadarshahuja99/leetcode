class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int start = 1;
        int end = -1;
        for(int num : nums)
        {
            end = Math.max(end, num);
        }
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(check(mid, maxOperations, nums))
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
    private boolean check(int guess, int max, int[] nums)
    {
        int ans = 0;
        for(int num : nums)
        {
            if(num <= guess)
            {
                continue;
            }
            int opsNeeded = num%guess == 0 ? num/guess - 1 : num/guess;
            if(opsNeeded > max)
            {
                return false;
            }
            max = max - opsNeeded;
        }
        return true;
    }
}
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            max = Math.max(max, nums[i]);
        }
        int s = 1;
        int e = max;
        int ans = -1;
        while(s <= e)
        {
            int m = s + (e - s)/2;
            if(check(m, nums, threshold))
            {
                ans = m;
                e = m-1;
            }
            else
            {
                s = m+1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int[] nums, int t)
    {
        long current = 0l;
        for(int num : nums)
        {
            current += (long)Math.ceil(1.0*num/guess);
            // System.out.println("current = " + current+" for num, guess = "+num+" "+guess);
            if(current > t)
            {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int min = 0;
        int max = queries.length-1;
        int ans = -1;
        boolean val = true;
        for(int num : nums)
        {
            if(num != 0)
            {
                val = false;
                break;
            }
        }
        if(val)
        {
            return 0;
        }
        while(min <= max)
        {
            int mid = min + (max - min)/2;
            if(check(mid, nums, queries))
            {
                ans = mid;
                max = mid-1;
            }
            else
            {
                min = mid+1;
            }
        }
        return ans == -1 ? -1 : ans+1;
    }
    private boolean check(int guess, int[] nums, int[][] queries)
    {
        int n = nums.length;
        int[] decr = new int[n+1];
        for(int it=0; it<=guess; it++)
        {
            int[] q = queries[it];
            decr[q[0]] -= q[2];
            decr[q[1]+1] += q[2];
        }
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            sum += decr[i];
            if(Math.abs(sum) < nums[i])
            {
                // System.out.println(false+" for "+guess);
                return false;
            }
        }
        // System.out.println(true+" for "+guess);
        return true;
    }
}
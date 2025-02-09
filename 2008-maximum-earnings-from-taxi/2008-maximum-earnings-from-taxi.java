class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, new Comparator<int[]>() {
            public int compare(int[] r1, int[] r2)
            {
                return r1[0] - r2[0];
            }
        });
        long[] dp = new long[rides.length+1];
        for(int current=rides.length-1; current>=0; current--)
        {
            // System.out.println("current: "+rides[current][0] + ", "+rides[current][1]+", "+rides[current][2]);
            int end = rides[current][1];
            int next = ceil(end,rides,current+1);
            long currentProfit = rides[current][1]-rides[current][0]+rides[current][2];
            long take = currentProfit;
            if(next != -1)
            {
                take = take + dp[next];
            }
            long notTake = dp[current+1];
            dp[current] = Math.max(take,notTake);
            // System.out.println("dp = " + dp[current] + " for  current: "+rides[current][0] + ", "+rides[current][1]+", "+rides[current][2]);
        }
        return dp[0];
    }
    // recurrence for reference
    private int getMax(int current, int n, int[][] rides)
    {
        if(current == rides.length)
        {
            return 0;
        }
        int end = rides[current][1];
        int next = ceil(end,rides,current+1);
        int currentProfit = rides[current][1]-rides[current][0]+rides[current][2];
        int take = currentProfit;
        if(next != -1)
        {
            take = take + getMax(next,n,rides);
        }
        int notTake = getMax(current+1,n,rides);
        return Math.max(take,notTake);
    }
    private int ceil(int target, int[][] nums, int start)
    {
        int end = nums.length-1;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid][0] >= target)
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
}
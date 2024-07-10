class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2)
            {
                return e1[0] - e2[0];
            }
        });
        int[][] dp = new int[events.length][k+1];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return getAns(0,k,events,dp);
    }
    private int getAns(int current, int k, int[][] events, int[][] dp)
    {
        if(k==0 || current == events.length)
        {
            return 0;
        }
        if(dp[current][k] != -1)
        {
            return dp[current][k];
        }
        int ceil = getCeil(events[current][1], events);
        if(ceil == -1)
        {
            return (dp[current][k] = Math.max(events[current][2], getAns(current+1, k, events, dp)));
        }
        return (dp[current][k] = Math.max(events[current][2] + getAns(ceil, k-1, events, dp), getAns(current+1, k, events, dp)));
    }
    private int getCeil(int target, int[][] events)
    {
        int start = 0;
        int end = events.length-1;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(events[mid][0] > target)
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
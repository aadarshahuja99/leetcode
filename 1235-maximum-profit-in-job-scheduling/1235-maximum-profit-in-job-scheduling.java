class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int numIntervals = profit.length;
        int[][] intervals = new int[numIntervals][3];
        for(int i=0; i<numIntervals; i++)
        {
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
        // for(int[] interval : intervals)
        // {
        //     System.out.println(interval[0]+" "+interval[1]);
        // }
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, -1);
        return getMaxProfitFromJobs(0, intervals, dp);
    }
    private int getMaxProfitFromJobs(int currentJobIndex, int[][] intervals, int[] dp)
    {
        if(currentJobIndex == intervals.length)
        {
            return 0;
        }
        if(dp[currentJobIndex] != -1)
        {
            return dp[currentJobIndex];
        }
        int ceil = getCeil(intervals[currentJobIndex][1], intervals);
        int notTake = getMaxProfitFromJobs(currentJobIndex+1, intervals, dp);
        if(ceil == -1)
        {
            return dp[currentJobIndex] = Math.max(intervals[currentJobIndex][2], notTake);
        }
        // System.out.println(ceil+" for "+currentJobIndex);
        int take = intervals[currentJobIndex][2] + getMaxProfitFromJobs(ceil, intervals, dp);
        return dp[currentJobIndex] = Math.max(take, notTake);
    }
    private int getCeil(int target, int[][] intervals)
    {
        int start = 0;
        int end = intervals.length-1;
        int ceil = -1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(intervals[mid][0] >= target)
            {
                ceil = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return ceil;
    }
}
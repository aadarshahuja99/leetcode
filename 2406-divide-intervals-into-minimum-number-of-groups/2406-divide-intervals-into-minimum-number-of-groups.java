class Solution {
    public int minGroups(int[][] intervals) {
        if(intervals.length == 1)
        {
            return 1;
        }
        int max = 0;
        int min = 1000001;
        for(int[] interval : intervals)
        {
            if(interval[0] < min)
            {
                min = interval[0];
            }
            if(interval[1] > max)
            {
                max = interval[1];
            }
        }
        int[] range = new int[max-min+2];
        for(int[] interval : intervals)
        {
            range[interval[0]-min]++;
            range[interval[1]-min+1]--;
        }
        int ans = 0;
        int runningSum = 0;
        for(int i=0; i<range.length; i++)
        {
            runningSum += range[i];
            ans = Math.max(ans,runningSum);
        }
        return ans;
    }
}
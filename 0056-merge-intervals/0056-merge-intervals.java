class Solution {
    public int[][] merge(int[][] intervals) {
        // sort the intervals by start time and end time
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
        ArrayList<int[]> ans = new ArrayList<>();        
        int i=0;
        while(i < intervals.length)
        {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            int j=i+1;
            while(j<intervals.length && intervals[j][0] <= currentEnd)
            {
                currentEnd = Math.max(currentEnd, intervals[j][1]);
                j++;
            }
            ans.add(new int[] { currentStart, currentEnd });
            i=j;
        }
        int[][] mergedIntervals = ans.toArray(new int[ans.size()][2]);
        return mergedIntervals;
    }
}
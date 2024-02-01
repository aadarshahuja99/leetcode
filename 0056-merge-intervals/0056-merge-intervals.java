class Solution {
    public int[][] merge(int[][] intervals) {
        // sort the intervals by start time and end time
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2)
            {
                if(interval1[0] != interval2[0])
                {
                    return interval1[0] - interval2[0];
                }
                return interval1[1] - interval2[1];
            }
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
                // System.out.println(currentEnd);
                j++;
            }
            ans.add(new int[] { currentStart, currentEnd });
            i=j;
        }
        int[][] mergedIntervals = ans.toArray(new int[ans.size()][2]);
        return mergedIntervals;
    }
}
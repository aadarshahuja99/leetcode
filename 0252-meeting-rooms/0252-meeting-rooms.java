class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
        int lastEnd = -1;
        int n = intervals.length;
        for(int i=0; i<n; i++)
        {
            if(lastEnd > intervals[i][0])
            {
                return false;
            }
            lastEnd = intervals[i][1];
        }
        return true;
    }
}
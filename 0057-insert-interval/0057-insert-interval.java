class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i=0;
        List<int[]> ans = new ArrayList<>();
        while(i<n && intervals[i][1] < newInterval[0])
        {
            ans.add(intervals[i]);
            i++;
        }
        while(i < n && intervals[i][0] <= newInterval[1])
        {
            // taking a union of the existing interval with the current version of new interval,
            // A union was also taken in the question: Count days without meetings: https://leetcode.com/problems/count-days-without-meetings LC: 3169
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);
        while(i < n)
        {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
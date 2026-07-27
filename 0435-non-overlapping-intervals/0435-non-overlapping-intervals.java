class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0)  return 0;
            Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
            int end = intervals[0][1];
            int keepCount = 1;
            // keep the earliest ending interval
            // example: [1,100] [2,3] [4,5] [6,7] if we sort by increasing starts then we will only be able to keep the first interval. As a result, sorting by increasing ends makes us keep the earliest ending interval as it will have the least overlap and occupy the least amount of timeline.
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= end) {
                    end = intervals[i][1];
                    keepCount++;
                }
            }
            return intervals.length - keepCount;
        }
}
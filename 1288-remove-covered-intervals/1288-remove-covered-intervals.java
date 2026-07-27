class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // sorting is similar to Russian doll
        int[][] copied = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(copied, (a,b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int ptr = 0;
        int n = intervals.length;
        int currentEnd = -1;
        int ans = n;
        while(ptr < n)
        {
            currentEnd = copied[ptr][1] - 1;
            int j = ptr+1;
            while(j < n && copied[j][0] <= currentEnd)
            {
                if(currentEnd >= copied[j][1]-1)
                {
                    ans--;
                }
                else
                {
                    currentEnd = copied[j][1]-1;
                }
                j++;
            }
            ptr = j;
        }
        return ans;
    }
}
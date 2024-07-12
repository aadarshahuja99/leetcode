class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        int n = events.length;
        int ans = 0;
        int lastEnd = 0;
        for(int i=0; i<n;)
        {
            int currentEnd = events[i][1];
            if(currentEnd <= lastEnd)
            {
                i++;
                continue;
            }
            int currentStart = Math.max(events[i][0], lastEnd + 1);
            int j=i+1;
            int count = 1;
            int days = currentEnd - currentStart + 1;
            // System.out.println(currentEnd+" "+currentStart);
            while(j < n && events[j][0] <= currentEnd && count < days)
            {
                currentEnd = Math.max(currentEnd, events[j][1]);
                days = currentEnd - currentStart + 1;
                j++;
                count++;
            }
            // System.out.println("curr end "+currentEnd+" last end "+lastEnd+" "+count+" "+days);
            // System.out.println();
            lastEnd = currentEnd;
            ans += Math.min(count, days);
            i=j;
        }
        return ans;
    }
}
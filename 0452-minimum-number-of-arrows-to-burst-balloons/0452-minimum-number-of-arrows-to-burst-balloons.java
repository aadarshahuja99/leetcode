class Solution {
    public int findMinArrowShots(int[][] points) {
        // not a range sum problem
        Arrays.sort(points, (a,b) -> {
            return a[0] - b[0];
        });
        int currentEnd = points[0][1];
        int ans = 1;
        for(int i=1; i<points.length; i++)
        {
            int[] current = points[i];
            if(currentEnd >= current[0])
            {
                currentEnd = Math.min(current[1], currentEnd);
            }
            else
            {
                currentEnd = current[1];
                ans++;
            }
        }
        return ans;
    }
}
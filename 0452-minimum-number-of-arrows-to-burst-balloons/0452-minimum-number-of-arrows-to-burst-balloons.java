class Solution {
    public int findMinArrowShots(int[][] points) {
        // same question as LC 435 non-overlapping intervals
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return Long.compare(a[1],b[1]);
            }
        });
        int currentEnd = points[0][1];
        int ans = 1;
        for(int i=1; i<points.length; i++)
        {
            int[] current = points[i];
            if(currentEnd < current[0])
            {
                currentEnd = current[1];
                ans++;
            }
        }
        return ans;
    }
}
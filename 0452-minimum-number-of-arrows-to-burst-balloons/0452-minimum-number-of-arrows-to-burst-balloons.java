class Solution {
    public int findMinArrowShots(int[][] points) {
        // not a range sum problem
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                if(a[1] == b[1])
                {
                    return Long.compare(a[0],b[0]);
                }
                return Long.compare(a[1],b[1]);
            }
        });
        int currentEnd = points[0][1];
        int ans = 1;
        // System.out.println(points[0][0] + " " + points[0][1]);
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
class Solution {
    public boolean isBoomerang(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2)
            {
                return p1[0]-p2[0];
            }
        });
        int[] p1 = points[0];
        int[] p2 = points[1];
        if(p2[0] == p1[0] && p2[1] == p1[1])
        {
            return false;
        }
        double slope1 = p2[0] == p1[0] ? Double.MAX_VALUE : (double)(p2[1]-p1[1])/(double)(p2[0]-p1[0]);
        int[] p3 = points[2];
        if((p3[0] == p2[0] && p3[1] == p2[1]) || (p3[0] == p1[0] && p3[1] == p1[1]))
        {
            return false;
        }
        double slope2 = p3[0] == p2[0] ? Double.MAX_VALUE : (double)(p3[1]-p2[1])/(double)(p3[0]-p2[0]);
        return slope1 != slope2;
    }
}
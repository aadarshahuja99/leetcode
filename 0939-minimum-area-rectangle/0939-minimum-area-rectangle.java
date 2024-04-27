class Solution {
    public int minAreaRect(int[][] points) {
        int numberOfPoints = points.length;
        HashMap<Integer, HashSet<Integer>> coordinateGroups = new HashMap<>();
        for(int[] point : points)
        {
            int x = point[0];
            int y = point[1];
            if(!coordinateGroups.containsKey(x))
            {
                coordinateGroups.put(x, new HashSet<>());
            }
            coordinateGroups.get(x).add(y);
        }
        int minArea = 17*100000000;
        for(int i=0; i<numberOfPoints; i++)
        {
            int x1 = points[i][0];
            int y1 = points[i][1];    
            for(int j=i+1; j<numberOfPoints; j++)
            {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1 == x2 || y1 == y2)
                {
                    continue;
                }
                int newPoint1x = x1;
                int newPoint1y = -1;
                if(coordinateGroups.get(x1).contains(y2))
                {
                    newPoint1y = y2;
                }
                int newPoint2x = x2;
                int newPoint2y = -1;
                if(coordinateGroups.get(x2).contains(y1))
                {
                    newPoint2y = y1;
                }
                if(newPoint1y == -1 || newPoint2y == -1)
                {
                    continue;
                }
                // System.out.println(x1+" "+x2+" "+y1+" "+y2);
                int area = Math.abs(x1 - x2)*Math.abs(y1 - y2);
                minArea = Math.min(minArea, area);

            }
        }
        if(minArea == 17*100000000)
        {
            return 0;
        }
        return minArea;
    }
}
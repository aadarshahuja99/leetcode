class Solution {
    public int maxPoints(int[][] points) {
        int max = 1;
        for(int[] point : points)
        {
            HashMap<Double,Integer> map = new HashMap<>();
            int currentX = point[0];
            int currentY = point[1];
            for(int[] other : points)
            {
                if(other[0] == currentX && other[1] == currentY)
                {
                    continue;
                }
                int newX = other[0];
                int newY = other[1];
                double slope = (double)(currentY - newY)/((double)(currentX - newX));
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope) + 1);
            }
        }
        return max;
    }
}
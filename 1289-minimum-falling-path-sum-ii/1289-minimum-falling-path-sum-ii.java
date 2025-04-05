class Solution {
    public int minFallingPathSum(int[][] grid) {
        return minCostII(grid);
    }
    private int minCostII(int[][] costs) {
        int minColor = Integer.MAX_VALUE;
        int prevMin = Integer.MAX_VALUE;
        int prevSecondMin = Integer.MAX_VALUE;
        int k = costs[0].length;
        int n = costs.length;
        for(int i=0; i<k; i++)
        {
            if(costs[0][i] < prevMin || prevMin == Integer.MAX_VALUE)
            {
                prevSecondMin = prevMin;
                prevMin = costs[0][i];
                minColor = i;
            }
            else if(costs[0][i] < prevSecondMin || prevSecondMin == Integer.MAX_VALUE)
            {
                prevSecondMin = costs[0][i];
            }
        }
        int ans = prevMin;
        // System.out.println(ans+" "+prevSecondMin+" "+minColor);
        for(int i=1; i<n; i++)
        {
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            int currentMinColor = Integer.MAX_VALUE;
            for(int j=0; j<k; j++)
            {
                int minCost = 0;
                if(j != minColor)
                {
                    minCost = costs[i][j] + prevMin;
                }
                else
                {
                    minCost = costs[i][j] + prevSecondMin;
                }
                if(minCost < min || min == Integer.MAX_VALUE)
                {
                    secondMin = min;
                    min = minCost;
                    currentMinColor = j;
                }
                else if(minCost < secondMin || secondMin == Integer.MAX_VALUE)
                {
                    secondMin = minCost;
                }
                // System.out.println(minCost+" "+j+" "+i+" "+costs[i][j]+" "+prevMin);
            }
            prevMin = min;
            prevSecondMin = secondMin;
            minColor = currentMinColor;
        }
        return prevMin;
    }
}
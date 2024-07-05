class Solution {
    public int minCostII(int[][] costs) {
        int minColor = -1;
        int prevMin = -1;
        int prevSecondMin = -1;
        int k = costs[0].length;
        int n = costs.length;
        for(int i=0; i<k; i++)
        {
            if(costs[0][i] < prevMin || prevMin == -1)
            {
                prevSecondMin = prevMin;
                prevMin = costs[0][i];
                minColor = i;
            }
            else if(costs[0][i] < prevSecondMin || prevSecondMin == -1)
            {
                prevSecondMin = costs[0][i];
            }
        }
        int ans = prevMin;
        // System.out.println(ans+" "+prevSecondMin+" "+minColor);
        for(int i=1; i<n; i++)
        {
            int min = -1;
            int secondMin = -1;
            int currentMinColor = -1;
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
                if(minCost < min || min == -1)
                {
                    secondMin = min;
                    min = minCost;
                    currentMinColor = j;
                }
                else if(minCost < secondMin || secondMin == -1)
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
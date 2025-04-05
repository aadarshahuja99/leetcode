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
                int currentCost = 0;
                if(j != minColor)
                {
                    currentCost = costs[i][j] + prevMin;
                }
                else
                {
                    currentCost = costs[i][j] + prevSecondMin;
                }
                if(currentCost < min || min == -1)
                {
                    secondMin = min;
                    min = currentCost;
                    currentMinColor = j;
                }
                else if(currentCost < secondMin || secondMin == -1)
                {
                    secondMin = currentCost;
                }
            }
            prevMin = min;
            prevSecondMin = secondMin;
            minColor = currentMinColor;
        }
        return prevMin;
    }
}
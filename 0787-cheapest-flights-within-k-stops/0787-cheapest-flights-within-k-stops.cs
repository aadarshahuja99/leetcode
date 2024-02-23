public class Solution {
    private readonly int defaultMin = 1000001;
    private HashSet<int> sources = new();
    private List<bool> visited = new();
    public int FindCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Dictionary<int,List<int>> dp = new();
        for(int i=0;i<flights.Length;i++)
        {
            visited.Add(false);
            if(!sources.Contains(flights[i][0]))
            {
                sources.Add(flights[i][0]);
            }
            if(!dp.ContainsKey(flights[i][0]))
            {
                dp.Add(flights[i][0], new List<int>());
                for(int j=0;j<=k+1;j++)
                {
                    dp[flights[i][0]].Add(-1);
                }
            }
        }
        int cost = GetMinCost(src,dst,k+1,flights,dp);
        if(cost >= defaultMin)
        {
            return -1;
        }
        return cost;
    }
    private int GetMinCost(int current, int dest, int k, int[][] flights, Dictionary<int,List<int>> dp)
    {
        if(k>=0 && current == dest)
        {
            return 0;
        }
        if(k==0)
        {
            return defaultMin;
        }
        if(!sources.Contains(current))
        {
            return defaultMin;
        }
        if(dp[current][k] != -1)
        {
            return dp[current][k];
        }
        int min = defaultMin;
        for(int i=0; i<flights.Length; i++)
        {
            if(flights[i][0] == current && !visited[i])
            {
                visited[i] = true;
                int cost = GetMinCost(flights[i][1],dest,k-1,flights,dp);
                visited[i] = false;
                if(cost >= defaultMin)
                {
                    continue;
                }
                min = Math.Min(min, flights[i][2] + cost);
            }
        }
        dp[current][k] = min;
        return min;
    }
}
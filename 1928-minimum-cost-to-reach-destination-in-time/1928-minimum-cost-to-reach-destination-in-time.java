class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<ArrayList<int[]>>();
        for(int i=0; i<passingFees.length; i++)
        {
            adjList.add(new ArrayList<int[]>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adjList.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }
        int n = passingFees.length;
        int[][] memo = new int[n][maxTime+1];
        for(int[] row : memo)
        {
            Arrays.fill(row,-1);
        }
        int ans = passingFees[0] + getAns(0,maxTime,adjList,memo,passingFees,n);
        if(ans > 1000000)
        {
            return -1;
        }
        return ans;
    }
    private int getAns(int current, int time, ArrayList<ArrayList<int[]>> adjList, int[][] memo, int[] passingFees, int n)
    {
        if(current == n-1 && time >= 0)
        {
            return 0;
        }
        if(time == 0)
        {
            return 1000001;
        }
        if(memo[current][time] != -1)
        {
            return memo[current][time];
        }
        int min = 1000001;
        for(int[] node : adjList.get(current))
        {
            if(time >= node[1])
            {
                min = Math.min(passingFees[node[0]] + getAns(node[0],time-node[1],adjList,memo,passingFees,n), min);
            }
        }
        return memo[current][time] = min;
    }
}
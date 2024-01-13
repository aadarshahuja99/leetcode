class Solution {
    long fuel = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        if(roads.length == 0)
        {
            return 0;
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=roads.length; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] road : roads)
        {
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
        }
        int[] totalReps = new int[roads.length+1];
        dfs(0,adjList,totalReps,seats);
        return fuel;
    }
    private int dfs(int current, ArrayList<ArrayList<Integer>> adjList, int[] totalReps, int seats)
    {
        totalReps[current] = 1;
        for(int node : adjList.get(current))
        {
            if(totalReps[node] == 0)
            {
                int pathReps = dfs(node,adjList,totalReps,seats);
                // Console.WriteLine($"path reps for {node}, {current}: {pathReps}");
                totalReps[current] += pathReps;
                if(pathReps%seats==0)
                {
                    fuel += pathReps/seats;
                }
                else
                {
                    fuel += (pathReps/seats) + 1;
                }
            }
        }
        return totalReps[current];
    }
}
class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(target == 1)
        {
            return n == 1 ? 1.0 : 0.0;
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        }
        boolean[] vis = new boolean[n];
        return getAns(0, vis, t, target-1, adjList);
    }
    private double getAns(int current, boolean[] visited, int time, int target, ArrayList<ArrayList<Integer>> adjList)
    {
        visited[current] = true;
        if(time == 0)
        {
            return 0.0;
        }
        int children = current == 0 ?  adjList.get(current).size() : adjList.get(current).size() - 1;
        if(children == 0)
        {
            return 0.0;
        }
        double probabilityPerPath = (double)1/(children*1.0);
        double ans = 0.0;
        for(int node : adjList.get(current))
        {
            if(visited[node])
            {
                continue;
            }
            if(node == target && (time == 1 || adjList.get(node).size() - 1 == 0))
            {
                // System.out.println("returning "+probabilityPerPath+" from "+current);
                return probabilityPerPath;
            }
            ans += probabilityPerPath*getAns(node, visited, time-1, target, adjList);
        }
        // System.out.println("returning "+ans+" from "+current);
        return ans;
    }
}
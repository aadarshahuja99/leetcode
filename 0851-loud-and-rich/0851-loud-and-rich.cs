public class Solution {
    public int[] LoudAndRich(int[][] richer, int[] quiet) {
        if(quiet.Length == 1)
        {
            return quiet;
        }
        List<List<int>> adjList = new();
        int[] visited = new int[quiet.Length];
        for(int i=0; i<quiet.Length; i++)
        {
            adjList.Add(new List<int>());
        }
        foreach(var pair in richer)
        {
            adjList[pair[1]].Add(pair[0]);
        }
        int[] ans = new int[quiet.Length];
        for(int i=0; i<quiet.Length; i++)
        {
            ans[i] = -1;
        }
        Stack<int> topologicalOrder = new();
        for(int i=0; i<quiet.Length; i++)
        {
            if(visited[i] == 0)
            {
                dfs(i,adjList,visited,topologicalOrder);
            }
        }
        while(topologicalOrder.Count > 0)
        {
            var top = topologicalOrder.Pop();
            // Console.WriteLine($"at {top}, ans: {ans[top]}");
            if(ans[top] == -1)
            {
                Calculate(top,adjList,quiet,ans);
            }
        }
        return ans;
    }
    private void dfs(int current, List<List<int>> adjList, int[] visited, Stack<int> topologicalOrder)
    {
        visited[current] = 1;
        foreach(var node in adjList[current])
        {
            if(visited[node] == 0)
            {
                dfs(node,adjList,visited,topologicalOrder);
            }
        }
        // Console.WriteLine($"adding {current} to the topo stack");
        topologicalOrder.Push(current);
    }
    private void Calculate(int current, List<List<int>> adjList, int[] quiet, int[] ans)
    {
        ans[current] = current;
        foreach(var node in adjList[current])
        {
            if(ans[node] != -1)
            {
                if(quiet[ans[node]] < quiet[ans[current]])
                {
                    ans[current] = ans[node];
                }
            }
            else
            {
                Calculate(node,adjList,quiet,ans);
                if(quiet[ans[node]] < quiet[ans[current]])
                {
                    ans[current] = ans[node];
                }
            }
        }
    }
}
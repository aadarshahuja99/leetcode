public class Solution {
    public IList<int> EventualSafeNodes(int[][] graph) {
        if(graph.Length == 1)
        {
            return graph[0].Length > 0 ? new List<int>() : new List<int> { 0 };
        }
        int n = graph.Length;
        int[] visited = new int[n];
        int[] currentPath = new int[n];
        LinkedList<int> ans = new();
        for(int i=0; i<n; i++)
        {
            if(visited[i] == 0)
            {
                dfs(i,graph,visited,currentPath,ans);
            }
        }
        var list = ans.ToList();
        list.Sort();
        return list;
    }
    private bool dfs(int current, int[][] adjList, int[] visited, int[] currentPath, LinkedList<int> ans)
    {
        visited[current] = 1;
        currentPath[current] = 1;
        foreach(int node in adjList[current])
        {
            if(visited[node] == 0)
            {
                bool canSchedule = dfs(node,adjList,visited,currentPath,ans);
                if(!canSchedule)
                {
                    return false;
                }
            }
            else if(currentPath[node] == 1)
            {
                return false;
            }
        }
        // revert the current path status when you backtrack to the previous call
        currentPath[current] = 0;
        ans.AddLast(current); // upon no detection of cycle for all paths from the current node, add it to the answer
        return true;
    }
}
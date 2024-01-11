public class Solution {
    public bool CanFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.Length == 0)
        {
            return true;
        }
        List<List<int>> adjList = new();
        for(int i=0; i<numCourses; i++)
        {
            adjList.Add(new List<int>());
        }
        foreach(var edge in prerequisites)
        {
            adjList[edge[0]].Add(edge[1]);
        }
        int[] visited = new int[numCourses];
        int[] currentPath = new int[numCourses];
        for(int i=0; i<numCourses; i++)
        {
            if(visited[i] == 0)
            {
                bool canSchedule = dfs(i,adjList,visited,currentPath);
                if(!canSchedule)
                {
                    return false;
                }
            }
        }
        return true;
    }
    private bool dfs(int current, List<List<int>> adjList, int[] visited, int[] currentPath)
    {
        visited[current] = 1;
        currentPath[current] = 1;
        foreach(int node in adjList[current])
        {
            if(visited[node] == 0)
            {
                bool canSchedule = dfs(node,adjList,visited,currentPath);
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
        return true;
    }
}
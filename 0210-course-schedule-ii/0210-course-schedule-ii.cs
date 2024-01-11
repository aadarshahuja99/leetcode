public class Solution {
    public int[] FindOrder(int numCourses, int[][] prerequisites) {
        // using Kahn's algorithm, we can detect if there is a cycle in the DG. If yes, return an empty list, else, return topological sort order of the graph
        if(numCourses == 1)
        {
            return new int[1] { 0 };
        }
        int[] indegree = new int[numCourses];
        Queue<int> bfs = new();
        List<List<int>> adjList = new();
        for(int i=0; i<numCourses; i++)
        {
            adjList.Add(new List<int>());
        }
        foreach(var prerequisite in prerequisites)
        {
            indegree[prerequisite[0]] += 1;
            adjList[prerequisite[1]].Add(prerequisite[0]);
        }
        for(int i=0; i<numCourses; i++)
        {
            if(indegree[i] == 0)
            {
                bfs.Enqueue(i);
            }
        }
        List<int> topologicalOrder = new();
        while(bfs.Count > 0)
        {
            var top = bfs.Dequeue();
            topologicalOrder.Add(top);
            foreach(var node in adjList[top])
            {
                indegree[node] -= 1;
                if(indegree[node] == 0)
                {
                    bfs.Enqueue(node);
                }
            }
        }
        if(topologicalOrder.Count == numCourses)
        {
            return topologicalOrder.ToArray();
        }
        return new int[0];
    }
}
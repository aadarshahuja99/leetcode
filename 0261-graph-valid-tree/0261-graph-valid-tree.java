class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] visited = new int[n];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for(int i=0; i<n; i++)
        {
            if(visited[i] == 0)
            {
                count++;
                if(count == 2 || detectCycle(i, -1, adjList, visited))
                {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean detectCycle(int currentNode, int parent, ArrayList<ArrayList<Integer>> adjList, int[] visited)
    {
        visited[currentNode] = 1;
        for(int child : adjList.get(currentNode))
        {
            if(visited[child] == 0)
            {
                detectCycle(child, currentNode, adjList, visited);
            }
            else if(child != parent)
            {
                return true;
            }
        }
        return false;
    }
}
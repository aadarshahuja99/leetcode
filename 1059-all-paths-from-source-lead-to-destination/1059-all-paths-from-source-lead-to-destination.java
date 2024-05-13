class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            if(edge[0] == destination)
            {
                return false;
            }
        }
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        return check(source,destination, visited, pathVisited, adjList);
    }
    private boolean check(int currentNode, int destination, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adjList)
    {
        if(adjList.get(currentNode).size() == 0)
        {
            return currentNode == destination;
        }
        visited[currentNode] = true;
        pathVisited[currentNode] = true;
        boolean ans = true;
        for(int child : adjList.get(currentNode))
        {
            if(!visited[child])
            {
                ans = ans && check(child, destination, visited, pathVisited, adjList);
            }
            else if(pathVisited[child])
            {
                return false;
            }
        }
        pathVisited[currentNode] = false;
        return ans;
    }
}
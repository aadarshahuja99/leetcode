class Solution {
    public int minScore(int n, int[][] roads) {
        int[] visited = new int[n];
        ArrayList<ArrayList<Element>> adjList = new ArrayList<ArrayList<Element>>();
        int[] min = new int[n];
        Arrays.fill(min,Integer.MAX_VALUE);
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<Element>());
        }
        for(int[] road : roads)
        {
            adjList.get(road[0]-1).add(new Element(road[1]-1,road[2]));
            adjList.get(road[1]-1).add(new Element(road[0]-1,road[2]));
            if(road[2] < min[road[0]-1])
            {
                min[road[0]-1]=road[2];
            }
            if(road[2] < min[road[1]-1])
            {
                min[road[1]-1]=road[2];
            }
        }
        dfs(0,visited,adjList);
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            // System.out.println("current min for i =  "+ i + " is " + min[i]);
            if(visited[i] != 0)
            {
                ans = Math.min(ans,min[i]);
            }
        }
        return ans;
    }
    private void dfs(int current, int[] visited, ArrayList<ArrayList<Element>> adjList)
    {
        visited[current] = 1;
        for(Element element : adjList.get(current))
        {
            if(visited[element.getNode()] != 1)
            {
                dfs(element.getNode(),visited,adjList);
            }
        }
    }
    class Element
    {
        int node;
        int distance;
        public Element(int n, int d)
        {
            node = n;
            distance = d;
        }
        public int getNode()
        {
            return node;
        }
        public int getDistance()
        {
            return distance;
        }
    }
}
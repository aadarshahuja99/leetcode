class Solution {
    int[] colors;
    ArrayList<ArrayList<Integer>> adjList;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Queue<Integer> q = new LinkedList<>();
        adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] e : dislikes)
        {
            adjList.get(e[0]-1).add(e[1]-1);
            adjList.get(e[1]-1).add(e[0]-1);
        }
        colors = new int[n];
        Arrays.fill(colors, -1);
        for(int i=0; i<n; i++)
        {
            if(colors[i] == -1)
            {
                if(!bfs(i))
                {
                    return false;
                }
            }
        }
        return true;
        
    }
    private boolean bfs(int start)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colors[start] = 0;
        while(q.size() > 0)
        {
            int top = q.poll();
            for(int node : adjList.get(top))
            {
                if(colors[node] != -1 && colors[node] == colors[top])
                {
                    return false;
                }
                if(colors[node] == -1)
                {
                    q.add(node);
                    colors[node] = colors[top] == 0 ? 1 : 0;
                }
            }
        }
        return true;
    }
}
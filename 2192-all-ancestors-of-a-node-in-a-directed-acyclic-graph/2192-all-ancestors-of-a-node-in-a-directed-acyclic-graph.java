class Solution {
    HashMap<Integer,HashSet> map = new HashMap<>();
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(n==1)
        {
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++)
        {
            ans.add(new ArrayList<Integer>());
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];
        for(int i=0; i<n; i++)
        {
            if(visited[i] == 0)
            {
                dfs(i,adjList,visited);
            }
        }
        for(Map.Entry<Integer,HashSet> set : map.entrySet())
        {
            if(set.getValue().size() > 0)
            {
                ArrayList<Integer> list = new ArrayList<Integer>(set.getValue());
                Collections.sort(list);
                List<Integer> target = ans.get(set.getKey());
                list.stream().forEachOrdered(target::add);
            }
        }
        return ans;
    }
    private void dfs(int current, ArrayList<ArrayList<Integer>> adjList, int[] visited)
    {
        visited[current] = 1;
        map.put(current,new HashSet<Integer>());
        HashSet<Integer> ancestors = map.get(current);
        for(int node : adjList.get(current))
        {
            ancestors.add(node);
            if(visited[node] == 0)
            {
                dfs(node,adjList,visited);
            }
            Iterator<Integer> it = map.get(node).iterator();
            while(it.hasNext())
            {
                ancestors.add(it.next());
            }
        }
    }
}
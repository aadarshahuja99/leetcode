class Solution {
    int ans = 0;
    HashMap<Integer,int[]> dp = new HashMap<>();
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        int[] indeg = new int[n];
        ArrayList<Integer> starts = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            indeg[edge[1]] += 1;
        }
        int idx = 0;
        int zeroCount = 0;
        for(int id : indeg)
        {
            if(id == 0)
            {
                starts.add(idx);
                zeroCount++;
            }
            idx++;
        }
        if(zeroCount == 0)
        {
            return -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int st : starts)
        {
            q.add(st);
        }
        int visitedCount = starts.size();
        while(q.size() > 0)
        {
            int top = q.poll();
            for(int node : adjList.get(top))
            {
                if(indeg[node] > 0)
                {
                    indeg[node]--;
                    if(indeg[node] == 0)
                    {
                        visitedCount++;
                        q.add(node);
                    }
                }
            }
        }
        // cycle detected in the graph
        if(visitedCount < n)
        {
            return -1;
        }
        HashMap<Integer,int[]> map = new HashMap<>();
        int[] visited = new int[n];
        for(int i=0; i<n; i++)
        {
            if(visited[i] == 0)
            {
                dfs(i,visited,adjList,colors);
            }
        }
        return ans;
    }
    private int[] dfs(int current, int[] visited, ArrayList<ArrayList<Integer>> adjList, String colors)
    {
        visited[current] = 1;
        int[] counts = new int[26];
        int currentColor = colors.charAt(current) - 97;
        int max = 0;
        for(int node : adjList.get(current))
        {
            if(!dp.containsKey(node))
            {
                var childCounts = dfs(node, visited, adjList, colors);
                for(int i=0; i<26; i++)
                {
                    counts[i] = Math.max(counts[i], childCounts[i]);
                    max = Math.max(max, counts[i]);
                }
            }
            else
            {
                var childCounts = dp.get(node);
                for(int i=0; i<26; i++)
                {
                    counts[i] = Math.max(counts[i], childCounts[i]);
                    max = Math.max(max, counts[i]);
                }
            }
        }
        counts[currentColor] += 1;
        max = Math.max(max, counts[currentColor]);
        ans = Math.max(ans, max);
        dp.put(current,counts);
        return counts;
    }
}
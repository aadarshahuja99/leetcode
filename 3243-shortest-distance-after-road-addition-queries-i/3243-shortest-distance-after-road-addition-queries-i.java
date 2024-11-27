class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        HashMap<Integer,HashSet<Integer>> additional = new HashMap<>();
        int[] ans = new int[queries.length];
        for(int i=0; i < queries.length; i++)
        {
            if(!additional.containsKey(queries[i][0]))
            {
                additional.put(queries[i][0], new HashSet<>());
            }
            additional.get(queries[i][0]).add(queries[i][1]);
            Queue<int[]> q = new LinkedList<>();
            int[] dist = new int[n];
            q.add(new int[] { 0, 0 });
            boolean[] v = new boolean[n];
            while(q.size() > 0)
            {
                int[] top = q.poll();
                if(v[top[0]])
                {
                    continue;
                }
                v[top[0]] = true;
                dist[top[0]] = top[1];
                int next = top[0] < n-1 ? top[0]+1 : -1;
                if(next == -1)
                {
                    // do nothing
                }
                else
                {
                    q.add(new int[] { next, top[1] + 1 });
                }
                for(int node : additional.getOrDefault(top[0], new HashSet<Integer>()))
                {
                    if(v[node] ||node == next)
                    {
                        continue;
                    }
                    q.add(new int[] { node, top[1]+1 });
                }
            }
            ans[i] = dist[n-1];
        }
        return ans;
    }
}
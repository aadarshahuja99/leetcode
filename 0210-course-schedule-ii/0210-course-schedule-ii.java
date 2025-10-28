class Solution {
    public int[] findOrder(int numCourses, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[numCourses];
        for(int[] edge : edges)
        {
            adj.get(edge[1]).add(edge[0]);
            indeg[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++)
        {
            if(indeg[i] == 0)
            {
                q.add(i);
                ans.add(i);
            }
        }
        if(q.size() == 0)
        {
            return new int[0];
        }
        while(q.size() > 0)
        {
            int top = q.poll();
            for(int node : adj.get(top))
            {
                indeg[node]--;
                if(indeg[node] == 0)
                {
                    q.add(node);
                    ans.add(node);
                }
            }
        }
        if(ans.size() < numCourses)
        {
            return new int[0];
        }
        int[] arr = new int[ans.size()];
        int idx = 0;
        for(int node : ans)
        {
            arr[idx] = node;
            idx++;
        }
        return arr;
    }
}
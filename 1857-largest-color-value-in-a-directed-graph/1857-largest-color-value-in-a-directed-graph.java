class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegree = new int[n];
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        int count = 0;
        int[][] colorCountsEndingAtNode = new int[n][26];
        int answer = 0;
        while(q.size() > 0)
        {
            int top = q.poll();
            int col = colors.charAt(top) - 'a';
            colorCountsEndingAtNode[top][col]++;
            int maxCur = 0;
            for(int i=0; i<26; i++)
            {
                maxCur = Math.max(maxCur, colorCountsEndingAtNode[top][i]);
            }
            answer = Math.max(answer, maxCur);
            count++;
            for(int node : adj.get(top))
            {
                for(int i=0; i<26; i++)
                {
                    colorCountsEndingAtNode[node][i] = Math.max(colorCountsEndingAtNode[node][i], colorCountsEndingAtNode[top][i]);
                }
                indegree[node]--;
                if(indegree[node] == 0)
                {
                    q.add(node);
                }
            }
        }
        if(count < n)
        {
            return -1;
        }
        return answer;
    }
}
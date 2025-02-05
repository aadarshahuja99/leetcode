class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a,b) -> {
            return a[1] - b[1];
        });
        int q = queries.length;
        int l = logs.length;
        int[][] cloned = new int[q][2];
        int idx = 0;
        for(int qu : queries)
        {
            cloned[idx] = new int[] { qu, idx };
            idx++;
        }
        Arrays.sort(cloned, (a,b) -> {
            return a[0] - b[0];
        });
        int[] ans = new int[q];
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int k=0;
        while(k < q)
        {
            int currentEnd = cloned[k][0];
            int start = currentEnd - x;
            int id = cloned[k][1];
            while(j < l && logs[j][1] <= currentEnd)
            {
                map.put(logs[j][0], map.getOrDefault(logs[j][0], 0) + 1);
                j++;
            }
            while(i < l && logs[i][1] < start)
            {
                map.put(logs[i][0], map.getOrDefault(logs[i][0], 0) - 1);
                if(map.get(logs[i][0]) == 0)
                {
                    map.remove(logs[i][0]);
                    // System.out.println("removed "+logs[i][0]+" at query: "+currentEnd+", "+start);
                }
                i++;
            }
            ans[id] = n - map.size();
            k++;
        }
        return ans;
    }
}
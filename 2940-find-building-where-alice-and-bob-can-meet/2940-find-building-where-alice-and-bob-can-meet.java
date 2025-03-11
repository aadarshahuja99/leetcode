class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        // storedQueries be like a bucket list which will store a list of int[] arrays for each higher  index of queries. each of these int[] arrays will contain, the maxHeight of the query and query index
        ArrayList<List<int[]>> storedQ = new ArrayList<>();
        int n = heights.length;
        for(int i=0; i<n; i++)
        {
            storedQ.add(new ArrayList<>());
        }
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        int idx = 0;
        for(int[] q : queries)
        {
            int a = q[0];
            int b = q[1];
            if(a < b && heights[a] < heights[b])
            {
                ans[idx] = b;
            }
            else if(a > b && heights[a] > heights[b])
            {
                ans[idx] = a;
            }
            else if(a == b)
            {
                ans[idx] = a;
            }
            else
            {
                storedQ.get(Math.max(a, b)).add(new int[] { Math.max(heights[a], heights[b]), idx });
            }
            idx++;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });
        for(int i=0; i<n; i++)
        {
            while(!minHeap.isEmpty() && minHeap.peek()[0] < heights[i])
            {
                ans[minHeap.peek()[1]] = i;
                minHeap.poll();
            }
            for(int[] queryData : storedQ.get(i))
            {
                minHeap.add(queryData);
            }
        }
        return ans;
    }
}
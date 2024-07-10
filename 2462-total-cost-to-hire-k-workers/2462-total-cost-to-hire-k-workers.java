class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        boolean[] added = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0])
            {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int start = -1;
        for(int i=0; i<Math.min(candidates,n); i++)
        {
            start++;
            pq.add(new int[] { costs[i], i, 0 });
            added[i] = true;
        }
        int end = n;
        for(int i=n-1; i>=Math.max(0, n-candidates); i--)
        {
            if(added[i])
            {
                break;
            }
            end--;
            pq.add(new int[] { costs[i], i, 1 });
            added[i] = true;
        }
        int selected = 0;
        long ans = 0l;
        while(selected < k && start < end)
        {
            int[] top = pq.poll();
            // System.out.println("adding "+top[0]+" "+top[1]+" "+top[2]);
            ans += top[0];
            selected++;
            if(top[2] == 1)
            {
                end--;
                if(end == start)
                {
                    // System.out.println("breaking");
                    break;
                }
                // System.out.println("queuing "+costs[end]+" "+end+" "+1);
                pq.add(new int[] { costs[end], end, 1 });
            }
            else
            {
                start++;
                if(end == start)
                {
                    // System.out.println("breaking");
                    break;
                }
                // System.out.println("queuing "+costs[start]+" "+start+" "+0);
                pq.add(new int[] { costs[start], start, 0 });
            }
        }
        while(selected < k)
        {
            var top = pq.poll();
            // System.out.println("adding "+top[0]+" "+top[1]+" "+top[2]);
            ans += top[0];
            selected++;
        }
        return ans;
    }
}
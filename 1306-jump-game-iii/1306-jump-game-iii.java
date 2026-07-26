class Solution {
    public boolean canReach(int[] arr, int start) {
        // apply bfs and check what all indices can be reached from start
        Queue<Integer> bfsQueue = new LinkedList<>();
        int n = arr.length;
        bfsQueue.add(start);
        boolean[] vis = new boolean[n];
        vis[start] = true;
        while(bfsQueue.size() > 0)
        {
            int s = bfsQueue.size();
            for(int i=0; i<s; i++)
            {
                int top = bfsQueue.poll();
                if(arr[top] == 0)
                {
                    return true;
                }
                if(top - arr[top] >= 0 && !vis[top - arr[top]])
                {
                    vis[top - arr[top]] = true;
                    bfsQueue.add(top - arr[top]);
                }

                if(top + arr[top] < n && !vis[top + arr[top]])
                {
                    vis[top + arr[top]] = true;
                    bfsQueue.add(top + arr[top]);
                }
            }
        }
        return false;
    }
}
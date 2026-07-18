class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // dfs/bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;
        int count = 1;
        while(q.size() > 0)
        {
            int top = q.poll();
            for(int room : rooms.get(top))
            {
                if(!vis[room])
                {
                    count++;
                    vis[room] = true;
                    q.add(room);
                }
            }
        }
        return count == rooms.size();
    }
}
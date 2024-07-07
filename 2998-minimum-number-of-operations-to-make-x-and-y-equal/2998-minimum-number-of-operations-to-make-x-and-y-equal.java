class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[] { x, 0 });
        while(bfs.size() > 0)
        {
            int[] top = bfs.poll();
            int current = top[0];
            int turns = top[1];
            if(current == y)
            {
                return turns;
            }
            if(!visited.contains(current + 1))
            {
                bfs.add(new int[] { current+1, turns+1 });
                visited.add(current+1);
            }
            if(current > y)
            {
                if(!visited.contains(current/11) && current%11 == 0)
                {
                    bfs.add(new int[] { current/11, turns+1 });
                    visited.add(current/11);
                }
                if(!visited.contains(current/5) && current%5 == 0)
                {
                    bfs.add(new int[] { current/5, turns+1 });
                    visited.add(current/5);
                }
                if(!visited.contains(current-1))
                {
                    bfs.add(new int[] { current-1, turns+1 });
                    visited.add(current-1);
                }
            }
        }
        return -1;
    }
}
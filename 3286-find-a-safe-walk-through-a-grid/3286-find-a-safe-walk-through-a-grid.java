class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        int[][] minObstacles = new int[m][n];
        for (int[] row : minObstacles) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        // Account for the starting cell's cost
        int startCost = grid.get(0).get(0);
        minObstacles[0][0] = startCost;
        deque.add(new int[] { 0, 0, startCost }); // {row, col, accumulatedObstacles}
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!deque.isEmpty()) {
            int[] top = deque.poll();
            int r = top[0];
            int c = top[1];
            int currentObs = top[2];
            
            // Early exit if we reached the bottom-right corner
            if (r == m - 1 && c == n - 1) {
                return (health - currentObs) >= 1;
            }
            
            // Skip outdated states
            if (currentObs > minObstacles[r][c]) {
                continue;
            }
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr < 0 || nr == m || nc < 0 || nc == n) {
                    continue;
                }
                
                int addedCost = grid.get(nr).get(nc);
                int newObs = currentObs + addedCost;
                
                if (newObs < minObstacles[nr][nc]) {
                    minObstacles[nr][nc] = newObs;
                    
                    // 0-1 BFS Logic: 
                    // Add 0-cost moves to the front, 1-cost moves to the back
                    if (addedCost == 0) {
                        deque.addFirst(new int[] { nr, nc, newObs });
                    } else {
                        deque.addLast(new int[] { nr, nc, newObs });
                    }
                }
            }
        }
        
        return false;
    }
}
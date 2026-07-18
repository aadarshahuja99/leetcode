class Solution {
    int[] deltaR = { 1,0,-1,0 };
    int[] deltaC = { 0,1,0,-1 };
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] q1, int[] q2)
            {
                return q1[0] - q2[0];
            }
        });
        int[][] distances = new int[m][n];
        for(int[] d : distances)
        {
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        distances[0][0] = 0;
        pq.add(new int[] { 0,0,0 });
        boolean[][] visited = new boolean[m][n];
        while(pq.size() > 0)
        {
            var top = pq.poll();
            int row = top[1];
            int col = top[2];
            int dist = top[0];
            if(row == m - 1 && col == n - 1)
            {
                return dist;
            }
            if(visited[row][col])
            {
                continue;
            }
            visited[row][col] = true;
            int iR = row;
            int iC = col;
            if(grid[row][col] == 1)
            {
                iC += 1;
            }
            else if(grid[row][col] == 2)
            {
                iC -= 1;
            }
            else if(grid[row][col] == 3)
            {
                iR += 1;
            }
            else
            {
                iR -= 1;
            }
            for(int i=0; i<4; i++)
            {
                int nR = row + deltaR[i];
                int nC = col + deltaC[i];
                if(nR >= 0 && nR < m && nC >= 0 && nC < n && !visited[nR][nC])
                {
                    int cost = 1;
                    if(iR == nR && iC == nC)
                    {
                        cost = 0;
                    }
                    if(distances[nR][nC] > dist + cost)
                    {
                        distances[nR][nC] = dist + cost;
                        pq.add(new int[] { distances[nR][nC],nR,nC });
                    }
                }
            }
        }
        return -1;
    }
}
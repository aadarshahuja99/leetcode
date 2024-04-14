class Solution {
    public int minCost(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1)
        {
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] q1, int[] q2)
            {
                return q1[0] - q2[0];
            }
        });
        int[][] distances = new int[grid.length][grid[0].length];
        for(int[] d : distances)
        {
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        distances[0][0] = 0;
        pq.add(new int[] { 0,0,0 });
        while(pq.size() > 0)
        {
            var top = pq.poll();
            int row = top[1];
            int col = top[2];
            int dist = top[0];
            if(row == grid.length - 1 && col == grid[0].length - 1)
            {
                return dist;
            }
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
            int[] deltaR = { 1,0,-1,0 };
            int[] deltaC = { 0,1,0,-1 };
            for(int i=0; i<4; i++)
            {
                int nR = row + deltaR[i];
                int nC = col + deltaC[i];
                if(nR >=0 && nR<grid.length && nC>=0 && nC <grid[0].length)
                {
                    int factor = 1;
                    if(iR == nR && iC == nC)
                    {
                        factor = 0;
                    }
                    if(distances[nR][nC] > dist + factor)
                    {
                        distances[nR][nC] = dist + factor;
                        pq.add(new int[] { distances[nR][nC],nR,nC });
                    }
                }
            }
        }
        return -1;
    }
}
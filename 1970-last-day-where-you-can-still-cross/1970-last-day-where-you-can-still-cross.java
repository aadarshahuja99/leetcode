class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        HashMap<Integer,Integer> cellDrowningDayMap = new HashMap<>();
        int idx = 0;
        for(int[] cell : cells)
        {
            cellDrowningDayMap.put(col*(cell[0] - 1) + (cell[1] - 1), idx);
            idx++;
        }
        int start = 0;
        int end = cells.length;
        int ans = 0;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(check(mid, cellDrowningDayMap, row, col))
            {
                ans = mid;
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return ans;
    }
    private boolean check(int guess, HashMap<Integer,Integer> cellDrowningDayMap, int m, int n)
    {
        boolean[][] visited = new boolean[m][n];
        for(int j=0; j<n; j++)
        {
            if(!visited[0][j] && cellDrowningDayMap.get(j) >= guess)
            {
                // System.out.println("map value = "+cellDrowningDayMap.get(j)+" for "+j);
                if(dfs(0, j, visited, cellDrowningDayMap, guess))
                {
                    // System.out.println("1: " + guess);
                    return true;
                }
            }
        }
        // System.out.println("2: " + guess);
        return false;
    }
    private boolean dfs(int row, int col, boolean[][] visited, HashMap<Integer,Integer> cellDrowningDayMap, int guess)
    {
        int m = visited.length;
        int n = visited[0].length;
        visited[row][col] = true;
        int[][] delta = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean ans = false;
        for(int i=0; i<4; i++)
        {
            int nR = row + delta[i][0];
            int nC = col + delta[i][1];
            if(nR == m-1 && cellDrowningDayMap.get(nR*n + nC) >= guess)
            {
                return true;
            }
            if(validatePosition(nR, nC, m, n) && !visited[nR][nC] && cellDrowningDayMap.get(nR*n + nC) >= guess)
            {
                // System.out.println("2: map value = "+cellDrowningDayMap.get(nR*n + nC)+" for "+nR+" ,"+nC);
                ans = ans || dfs(nR, nC, visited, cellDrowningDayMap, guess);
                if(ans)
                {
                    return ans;
                }
            }
        }
        return false;
    }
    private boolean validatePosition(int row, int col, int m, int n)
    {
        return row < m && row >= 0 && col < n && col >= 0;
    }
}
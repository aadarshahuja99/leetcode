class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] next = new int[n];
        for(int i=0; i<n; i++)
        {
            next[i] = triangle.get(n-1).get(i);
        }
        for(int row = n-2; row >= 0; row--)
        {
            int[] current = new int[n];
            for(int col = row; col >= 0; col--)
            {
                int moveToSameCol = triangle.get(row).get(col) + next[col];
                int moveToDiffCol = triangle.get(row).get(col) + next[col+1];
                current[col] = Math.min(moveToSameCol, moveToDiffCol);
            }
            next = current;
        }
        return next[0];
    }
    private int getAns(int row, int col, List<List<Integer>> triangle, int[][] cache)
    {
        if(row == triangle.size())
        {
            return 0;
        }
        if(cache[row][col] != -1)
        {
            return cache[row][col];
        }
        int moveToSameCol = triangle.get(row).get(col) + getAns(row+1, col, triangle, cache);
        int moveToDiffCol = triangle.get(row).get(col) + getAns(row+1, col+1, triangle, cache);
        return cache[row][col] = Math.min(moveToSameCol, moveToDiffCol);
    }
}
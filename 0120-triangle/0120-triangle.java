class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] cache = new int[triangle.size()][triangle.size()];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, 0, triangle, cache);
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
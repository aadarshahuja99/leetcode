class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minAbs = Integer.MAX_VALUE;
        long totalSum = 0l;
        int negCount = 0;
        for(int[] row : matrix)
        {
            for(int val : row)
            {
                minAbs = Math.min(Math.abs(val), minAbs);
                totalSum += Math.abs(val);
                if(val < 0)
                {
                    negCount++;
                }
            }
        }
        if(negCount%2 == 0)
        {
            return totalSum;
        }
        return totalSum - 2*minAbs;
    }
}
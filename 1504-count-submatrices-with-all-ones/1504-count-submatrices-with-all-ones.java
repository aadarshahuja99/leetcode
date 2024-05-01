class Solution {
    public int numSubmat(int[][] mat) {
        // O(r2*c) time complexity solution
        int[][] processedMatrix = processMatrix(mat);
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int minSoFar = 200;
                int currentCount = 0;
                for(int k=i; k<m; k++)
                {
                    minSoFar = Math.min(minSoFar, processedMatrix[k][j]);
                    currentCount += minSoFar;
                }
                ans += currentCount;
            }
        }
        return ans;
    }
    private int[][] processMatrix(int[][] mat)
    {
        int m = mat.length; // rows
        int n = mat[0].length; // columns
        int[][] suffixSums = new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(mat[i][j] == 1)
                {
                    if(j < n-1)
                    {
                        suffixSums[i][j] = 1 + suffixSums[i][j+1];
                    }
                    else
                    {
                        suffixSums[i][j] = 1;
                    }
                }
            }
        }
        return suffixSums;
    }
}